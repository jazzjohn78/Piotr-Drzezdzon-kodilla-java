package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForumUserTestSuite {
    @Test
    void testGetUserName() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser user = new ForumUser();

        //When
        String username = user.getUsername();

        //Then
        assertEquals("John Smith", username);
    }
}
