package org.sobew.exceptions;

/**
 * Created by Michael Buck
 * 15-Aug-2018
 */

public class ProfileInvalidRequestException extends Exception {
  /**
   * Creates an <code>InvalidJwtException</code> with a message.
   *
   * @param mess The message to be included in the exception.
   * @see Exception#Exception(String)
   */
  public ProfileInvalidRequestException(String mess) {
    super(mess);
  }

  /**
   * Creates a <code>InvalidJwtException</code> with a message and a cause.
   *
   * @param mess  The message to be included in the exception.
   * @param cause The cause of the exception.
   * @see Exception#Exception(String,Throwable)
   */
  public ProfileInvalidRequestException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
