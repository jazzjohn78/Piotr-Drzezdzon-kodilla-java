package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("using Twitter");
        return "using Twitter";
    }
}
