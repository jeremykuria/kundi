package com.kundi.kundi.security.error;

public class UserNotAuthorisedException extends Exception {
    public UserNotAuthorisedException() {
    }

    public UserNotAuthorisedException(String s) {
        super(s);
    }

    public UserNotAuthorisedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserNotAuthorisedException(Throwable throwable) {
        super(throwable);
    }
}
