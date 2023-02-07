package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessegeSender messegeSender = new MessegeSender();

        try {
            messegeSender.sendMessageTo(user, "Hello!");
        } catch (MessegaNotSentException e) {
            System.out.println("Message is not sent," + " but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}
