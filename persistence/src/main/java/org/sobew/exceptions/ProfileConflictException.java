package org.sobew.exceptions;

public class ProfileConflictException  extends Exception {
  public ProfileConflictException(String mess) {
    super(mess);
  }
  public ProfileConflictException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
