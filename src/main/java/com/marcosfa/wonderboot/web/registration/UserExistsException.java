package com.marcosfa.wonderboot.web.registration;

import javax.lang.model.type.ErrorType;

public class UserExistsException extends Exception {
    final ErrorType errorType;

    public UserExistsException( final ErrorType errorType) {
        this.errorType = errorType;
    }

  public ErrorType getErrorType() {
    return errorType;
  }

  public enum ErrorType {
    EMAIL_EXISTS,
    USERNAME_EXISTS
  }
}
