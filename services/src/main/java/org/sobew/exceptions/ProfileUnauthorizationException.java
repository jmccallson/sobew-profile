package org.sobew.exceptions;

public class ProfileUnauthorizationException extends Exception{
  public ProfileUnauthorizationException(String message, Throwable throwable){
    super(message, throwable);
  }
}
