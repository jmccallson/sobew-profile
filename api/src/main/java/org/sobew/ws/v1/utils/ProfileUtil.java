package org.sobew.ws.v1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobew.entities.ProfileUserEntity;
import org.sobew.exceptions.ProfileInternalException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProfileUtil {
  public static final String OK_CONDITION_MSG = "Success";
  public static final String NO_CONTENT_CONDITION_MSG = OK_CONDITION_MSG + " (no content)";
  public static final String INVALID_RQST_CONDITION_MSG = "Bad request - Invalid json object, json with missing required data, missing or invalid request header";
  public static final String INVALID_LEVEL_CONDITION_MSG = "Bad request - invalid log-level";
  public static final String UNAUTHORIZED_CONDITION_MSG = "Unauthorized - sessionId may not be null or empty, or sessionId has expired";
  public static final String USER_NOT_FOUND_CONDITION_MSG = "User not found - sessionId cannot be found";
  public static final String INTERNAL_ERR_CONDITION_MSG = "Internal server error (unexpected error)";
  private static final Logger LOG = LoggerFactory.getLogger(ProfileUtil.class);

  private static final String AUTHORIZATION_BEARER = "Bearer";

  @SuppressWarnings("squid:S134")
  public static String getBearerToken(String adminAccessToken) {
    String adminSessionId = null;
    if (stringNotEmpty(adminAccessToken)) {
      List<String> tokens = Arrays.asList(adminAccessToken.split("\\s+"));
      if (!tokens.isEmpty()) {
        for (int indx = 0; indx < tokens.size(); indx++) {
          if (AUTHORIZATION_BEARER.equalsIgnoreCase(tokens.get(indx))) {
            adminSessionId = tokens.get(indx + 1);
            break;
          }
        }
      }
    }
    return adminSessionId;
  }

  public static String profileUserDataToJson(ProfileUserEntity profileUserEntity){
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr;
    try {
      jsonStr = mapper.writeValueAsString(profileUserEntity);
    } catch (JsonProcessingException e) {
      throw new ProfileInternalException("Unable to map profile to json", e);
    }
    return jsonStr;
  }

  public static ProfileUserEntity jsonToProfileUserData(String payload){
    ObjectMapper mapper = new ObjectMapper();
    ProfileUserEntity profileUserEntity;
    try {
      JsonNode root = mapper.readTree(payload);
      profileUserEntity = mapper.treeToValue(root, ProfileUserEntity.class);
    } catch (IOException e) {
      throw new ProfileInternalException("Unable to convert json to object", e);
    }
    return profileUserEntity;
  }

  public static boolean stringNotEmpty(String string) {
    return string != null && !string.trim().isEmpty();
  }

}
