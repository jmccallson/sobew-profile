package org.sobew.ws.v1;

import net.logstash.logback.marker.LogstashMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobew.exceptions.*;
import org.sobew.managers.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static net.logstash.logback.marker.Markers.append;

public class ExceptionHandler {
  public static final String USER_AGENT = "User-Agent";
  public static final String USER_AGENT_CHAIN = "FS-User-Agent-Chain";
  private static final Logger EXC_LOGGER = LoggerFactory.getLogger( ExceptionHandler.class);
  private static final String SERVER_ERROR = "server_error";

  private ExceptionHandler() {
  }

  //==========================================================================
  //   PUBLIC STATIC Methods
  //==========================================================================

  ///
  // Map a run-time exception to an HTTP status response.  Log some
  //  specific details about the exception.
  // Create a CompletionDetails object containing a summary of the error.
  ///
  public static ResponseEntity<String> handleExceptions(Exception exception, HttpServletRequest request, HttpServletResponse httpResponse) {

    HttpStatus  status;
    String error = SERVER_ERROR;

    if ((exception instanceof ProfileUnauthorizedException) ||
      (exception instanceof ProfileExpiredSessionException)) {
      status = HttpStatus.UNAUTHORIZED;
      error = exception.getMessage();
    }
    else if (exception instanceof ProfileInvalidRequestException) {
      status = HttpStatus.BAD_REQUEST;
      error =exception.getMessage();

    }
    else if (exception instanceof ProfileNotFoundException) {
      status = HttpStatus.NOT_FOUND;
      error = exception.getMessage();

    }
    else if (exception instanceof ProfileConflictException) {
      status = HttpStatus.CONFLICT;
      error = exception.getMessage();

    }
    else {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    httpResponse.setStatus(status.value());
    String userAgent = request.getHeader(USER_AGENT);
    String userAgentChain = request.getHeader(USER_AGENT_CHAIN);
    LogstashMarker markers = append(USER_AGENT, userAgent);
    markers.add(append(USER_AGENT_CHAIN, userAgentChain));

    if (status.is5xxServerError()) {
      EXC_LOGGER.error(markers, "HTTP 5xx error:", exception);
    }
    else {
      EXC_LOGGER.warn(markers, "Unexpected error:", exception);
    }

    String errorMessage = StringUtils.stringNotEmpty(error) ? getErrorMessage(error, exception.getMessage()) : "";
    return new ResponseEntity<>(errorMessage, status);
  }

  //==========================================================================
  //   PRIVATE STATIC Methods
  //==========================================================================

  private static String getErrorMessage(String error, String message) {
    return "{\"error\":\"" + error + "\",\"error_description\":\"" + message + "\"}";
  }
}
