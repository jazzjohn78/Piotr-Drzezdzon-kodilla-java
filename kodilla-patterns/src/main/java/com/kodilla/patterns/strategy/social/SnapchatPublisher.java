package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("using Snapchat");
        return "using Snapchat";
    }
}
