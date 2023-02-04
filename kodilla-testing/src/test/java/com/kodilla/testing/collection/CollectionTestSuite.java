package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @DisplayName(
            "when executing exterminate method with empty List " +
            "then it should return List with size 0"
    )
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> list = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> resultList = exterminator.exterminate(list);
        int result = resultList.size();
        //Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName(
            "when executing exterminate method with List containing odd and even numbers" +
            "then it should return List with even numbers only"
    )
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> list = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(4);
        expectedResult.add(6);
        //When
        List<Integer> result = exterminator.exterminate(list);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(
            "when using Arrays.asList() to test executing exterminate method with List containing odd and even numbers" +
            "then it should return List with even numbers only"
    )
    @Test
    void testOddNumbersExterminatorExtraTask(){
        //Given
        Integer[] testNumbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 33, 34, 248, 457};
        List<Integer> list = Arrays.asList(testNumbers);
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        Integer[] expectedNumbers = new Integer[] {2, 4, 6, 8, 34, 248};
        List<Integer> expectedResult = Arrays.asList(expectedNumbers);
        //When
        List<Integer> result = exterminator.exterminate(list);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
