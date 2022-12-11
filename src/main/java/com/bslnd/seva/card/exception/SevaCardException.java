package com.bslnd.seva.card.exception;

public class SevaCardException extends RuntimeException{


    private final int errorCode;
    private final String message;

    public SevaCardException(final Throwable cause, final int errorCode, final String message) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
