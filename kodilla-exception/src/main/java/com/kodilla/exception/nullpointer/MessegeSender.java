package com.kodilla.exception.nullpointer;

public class MessegeSender {

    public void sendMessageTo(User user, String message) throws MessegaNotSentException {
        if(user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        } else {
            throw new MessegaNotSentException("Object User was null");
        }
    }
}
