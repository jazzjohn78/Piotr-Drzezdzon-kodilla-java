package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    Calculator calculator;
    @Test
    void testCalculations() {
        //Given
        //When
        double result1 = calculator.add(10.5, 3.2);
        double result2 = calculator.sub(10.5, 3.2);
        double result3 = calculator.mul(10.5, 3.2);
        double result4 = calculator.div(10.5, 3.2);

        //Then
        assertEquals(13.7, result1);
        assertEquals(7.3, result2);
        assertEquals(33.6, result3);
        assertEquals(3.28125, result4);
    }
}
