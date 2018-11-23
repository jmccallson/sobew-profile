package org.sobew.exceptions;

public class ProfileExpiredSessionException extends Exception{
  public ProfileExpiredSessionException(String message, Throwable throwable){
    super(message, throwable);
  }
}
