package com.bslnd.seva.card.exception;

public enum SevaCardErrorCode {

    /**
     * Validation exception.
     */
    VALIDATION_EXCEPTION(1001, "Validation Failure"),

    /**
     * Could not save data locally to file.
     */
    COULD_NOT_SAVE_SEVADAR_LOCALLY(1002, "Could not save sevadar locally"),

    /**
     * Could not create file to save data locally.
     */
    COULD_NOT_CREATE_FILE_LOCALLY(1003, "Could not create file locally");

    private int errorCode;

    private String description;

    SevaCardErrorCode(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}