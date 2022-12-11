package com.bslnd.seva.card.exception;

public class Error {

    private String errorMessage;

    private int errorCode;

    private String errorDescription;

    public Error(final String errorMessage, final int errorCode, final String errorDescription) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
