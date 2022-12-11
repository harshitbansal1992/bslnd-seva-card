package com.bslnd.seva.card.controller;

import com.bslnd.seva.card.exception.Error;
import com.bslnd.seva.card.exception.SevaCardErrorCode;
import com.bslnd.seva.card.exception.SevaCardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class SevaCardExceptionHandler extends ResponseEntityExceptionHandler {


    private Map<Integer, HttpStatus> exceptionResponseMapping = new HashMap<>();

    public SevaCardExceptionHandler() {
        exceptionResponseMapping.put(SevaCardErrorCode.COULD_NOT_SAVE_SEVADAR_LOCALLY.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SevaCardException.class)
    protected ResponseEntity<Object> handleValidationFailure(final SevaCardException exception, final WebRequest webRequest) {
        Error error =new Error(exception.getMessage(), exception.getErrorCode(), null);
        return handleExceptionInternal(exception, error, null, exceptionResponseMapping.get(exception.getErrorCode()), webRequest);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleValidationFailure(final ConstraintViolationException exception, final WebRequest webRequest) {
        List<String> errorMessages = new ArrayList<>();
        exception.getConstraintViolations().forEach(error -> {
            errorMessages.add(error.getMessage());
        });
        Error error =new Error(String.join(",", errorMessages), SevaCardErrorCode.VALIDATION_EXCEPTION.getErrorCode(), SevaCardErrorCode.VALIDATION_EXCEPTION.getDescription());
        return handleExceptionInternal(exception, error, null, HttpStatus.BAD_REQUEST, webRequest);
    }
}
