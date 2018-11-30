package org.sobew.exceptions;

public class ProfileAlreadyExistsException extends Exception {
  public ProfileAlreadyExistsException(String mess) {
    super(mess);
  }
  public ProfileAlreadyExistsException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
