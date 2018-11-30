package org.sobew.ws.v1.controllers;

import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import net.logstash.logback.marker.LogstashMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobew.ProfileUserService;
import org.sobew.entities.ProfileUserEntity;
import org.sobew.exceptions.*;
import org.sobew.ws.v1.utils.ProfileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;

import static net.logstash.logback.marker.Markers.append;
import static org.sobew.ws.v1.ExceptionHandler.USER_AGENT;
import static org.sobew.ws.v1.ExceptionHandler.handleExceptions;

@RestController
public class ProfileUserController {
  //private static final String USER_AGENT = "User-Agent";
  private static final String USER_AGENT_CHAIN = "User-Agent-Chain";
  private static final Logger LOG = LoggerFactory.getLogger(ProfileUserController.class);
  private static final String NO_SESSION_ELEMENT_FOUND = "No session element found";
  private final ProfileUserService profileUserService;

  public ProfileUserController(ProfileUserService profileUserService){
    this.profileUserService = profileUserService;
  }

  /**
   * @param authHeader "Authorization Bearer {sessionId}" as defined in rfc6750
   */
  @StatusCodes({
    @ResponseCode(code = HttpURLConnection.HTTP_OK, condition = ProfileUtil.OK_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_BAD_REQUEST, condition = ProfileUtil.INVALID_RQST_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_UNAUTHORIZED, condition = ProfileUtil.UNAUTHORIZED_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_NOT_FOUND, condition = ProfileUtil.USER_NOT_FOUND_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_INTERNAL_ERROR, condition = ProfileUtil.INTERNAL_ERR_CONDITION_MSG)
  })
  @RequestMapping(value = "/userprofile",  method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Object> createUserProfile(@RequestHeader("Authorization") String authHeader, //NOSONAR
                                                  @RequestBody ProfileUserEntity profileUserEntity,
                                                  WebRequest request)
    throws ProfileExpiredSessionException, ProfileInvalidRequestException, ProfileNotFoundException, ProfileUnauthorizedException, ProfileConflictException {
    String sessionId = ProfileUtil.getBearerToken(authHeader);
    if(sessionId == null || sessionId.isEmpty()){
      throw new ProfileExpiredSessionException(NO_SESSION_ELEMENT_FOUND, new Throwable(ProfileUtil.UNAUTHORIZED_CONDITION_MSG));
    }

    if(null == profileUserEntity){
      throw new ProfileInvalidRequestException("Request body is null", new Throwable(ProfileUtil.INVALID_RQST_CONDITION_MSG));
    }
    ProfileUserEntity newProfileUserData = profileUserService.create(sessionId, profileUserEntity);

    String userAgent = request.getHeader(USER_AGENT);
    String userAgentChain = request.getHeader(USER_AGENT_CHAIN);
    LogstashMarker markers = getLogMarkers(userAgent, userAgentChain);
    LOG.info(markers, "User-Profile /userprofile endpoint success with Payload {}.", ProfileUtil.profileUserDataToJson(profileUserEntity));
    return new ResponseEntity<>(newProfileUserData, HttpStatus.OK);
  }

  @ExceptionHandler(value = {
    ProfileExpiredSessionException.class,
    ProfileInternalException.class,
    ProfileUnauthorizedException.class,
    ProfileInvalidRequestException.class,
    ProfileNotFoundException.class,
    ProfileConflictException.class,
    RuntimeException.class})
  @ResponseBody
  private ResponseEntity<String> handleExceptionsWithHttpResponse(Exception exception, HttpServletRequest request, HttpServletResponse response ) {
    return handleExceptions(exception, request, response);
  }

  private LogstashMarker getLogMarkers(String userAgent, String userAgentChain) {
    LogstashMarker markers = append(USER_AGENT, userAgent);
    markers.add(append(USER_AGENT_CHAIN, userAgentChain));
    return markers;
  }
}
