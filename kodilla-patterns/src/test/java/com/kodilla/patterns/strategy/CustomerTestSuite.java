package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillashouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillashouldBuy);

        //Then
        assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillashouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);

        //Then
        assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
