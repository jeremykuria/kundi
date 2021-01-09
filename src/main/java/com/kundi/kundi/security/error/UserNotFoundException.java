package com.kundi.kundi.security.error;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {

    public UserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
