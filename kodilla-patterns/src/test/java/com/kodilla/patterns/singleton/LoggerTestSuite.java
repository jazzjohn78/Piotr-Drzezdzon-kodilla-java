package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void createLogger() {
        logger = Logger.INSTANCE;
    }

    @Test
    void testGetLastLogOneEntry() {
        //Given
        logger.log("entry");

        //When
        String result = logger.getLastLog();

        //Then
        assertEquals("entry", result);
    }

    @Test
    void testGetLastLogMoreEntries() {
        //Given
        logger.log("first entry");
        logger.log("second entry");
        logger.log("third entry");

        //When
        String result = logger.getLastLog();

        //Then
        assertEquals("third entry", result);
    }
}
