package com.anil.rbc.application;

/**
 * Created by anilterli on 1/26/16.
 */
public class InvalidUserInputException extends Exception {

    public InvalidUserInputException() {
    }

    public InvalidUserInputException(String message) {
        super(message);
    }

    public InvalidUserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
