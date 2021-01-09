package com.kundi.kundi.security.error;

public class EmailAlreadyUsedException extends Exception {
    public EmailAlreadyUsedException() {
    }

    public EmailAlreadyUsedException(String message) {
        super(message);
    }

    public EmailAlreadyUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyUsedException(Throwable cause) {
        super(cause);
    }

    public EmailAlreadyUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
