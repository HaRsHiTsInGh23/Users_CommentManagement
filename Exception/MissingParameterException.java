package com.assign.commentsApi.Exception;

/**
 * This is an Exception class for missing request parameter. 
 * That is, if the @requestParam is  missing from API then it helps in identifying and showing the message.
 */
public class MissingParameterException extends RuntimeException {
    public MissingParameterException(String message) {
        super(message);
    }
}
