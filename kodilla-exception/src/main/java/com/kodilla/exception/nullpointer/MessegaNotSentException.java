package com.kodilla.exception.nullpointer;

public class MessegaNotSentException extends Exception {

    public MessegaNotSentException(final String message) {
        super(message);
    }
}
