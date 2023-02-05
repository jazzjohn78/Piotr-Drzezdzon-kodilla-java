package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        //Europe
        Country poland = new Country(new BigDecimal("38000000"));
        Country germany = new Country(new BigDecimal("32000000"));
        Country france = new Country(new BigDecimal("45000000"));
        Continent europe = new Continent();
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        //Africa
        Country mali = new Country(new BigDecimal("55000000"));
        Country southAfrica = new Country(new BigDecimal("27000000"));
        Continent africa = new Continent();
        africa.addCountry(mali);
        africa.addCountry(southAfrica);
        //Asia
        Country china = new Country(new BigDecimal("2000000000"));
        Country india = new Country(new BigDecimal("1000000000"));
        Country japan = new Country(new BigDecimal("20000000"));
        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(japan);
        //World
        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("3217000000");
        assertEquals(expectedPopulation, worldPopulation);
    }
}
