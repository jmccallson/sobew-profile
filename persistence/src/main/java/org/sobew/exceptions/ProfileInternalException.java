package org.sobew.exceptions;

public class ProfileInternalException extends RuntimeException {
  public ProfileInternalException(String mess) {
    super(mess);
  }
  public ProfileInternalException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
