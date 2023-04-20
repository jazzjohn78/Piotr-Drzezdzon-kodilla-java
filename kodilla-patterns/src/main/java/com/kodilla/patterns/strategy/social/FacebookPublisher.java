package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("using Facebook");
        return "using Facebook";
    }
}
