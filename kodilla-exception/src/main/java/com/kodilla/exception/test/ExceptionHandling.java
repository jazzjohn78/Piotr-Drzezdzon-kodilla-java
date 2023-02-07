package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(2.5, 1.0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ajajajajaj... Puerto Rico! Exception: " + e);
        } finally {
            System.out.println("Miło Cię widzieć :)");
        }
    }
}
