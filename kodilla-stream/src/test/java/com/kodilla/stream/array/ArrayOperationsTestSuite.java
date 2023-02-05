package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[]{15, 5, 55, 54, 8, 0, 78, 5, 44, 6, 0, 4, 1, 2, 5, 6, 7, 8, 9, 0};

        //When
        double averageResult = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(15.6, averageResult);
    }
}
