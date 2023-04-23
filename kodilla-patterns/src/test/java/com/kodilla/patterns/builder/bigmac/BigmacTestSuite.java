package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bigmac.SESAME)
                .burgers(2)
                .sauce(Bigmac.BARBECUE)
                .ingredient(Bigmac.LETTUCE)
                .ingredient(Bigmac.CUCUMBER)
                .ingredient(Bigmac.CHEESE)
                .ingredient(Bigmac.CHILI_PEPPERS)
                .build();
        System.out.println(bigmac);

        //When & Then
        assertEquals(Bigmac.SESAME, bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals(Bigmac.BARBECUE, bigmac.getSauce());
        assertEquals(4, bigmac.getIngredients().size());
    }
}
