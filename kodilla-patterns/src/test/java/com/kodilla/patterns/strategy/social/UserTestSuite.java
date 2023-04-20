package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("John");
        User user2 = new YGeneration("Alina");
        User user3 = new ZGeneration("Zuza");

        //When
        String user1Publisher = user1.sharePost();
        String user2Publisher = user2.sharePost();
        String user3Publisher = user3.sharePost();

        //Then
        assertEquals("using Facebook", user1Publisher);
        assertEquals("using Twitter", user2Publisher);
        assertEquals("using Snapchat", user3Publisher);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("John");

        //When
        String user1Publisher = user1.sharePost();
        user1.setSocialPublisher(new TwitterPublisher());
        user1Publisher = user1.sharePost();

        //Then
        assertEquals("using Twitter", user1Publisher);
    }
}
