package com.kodilla.patterns2.decorator.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    void testBaconOnionBroccoliPizzaGetPrice() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        pizza = new BroccoliDecorator(pizza);
        //when
        BigDecimal price = pizza.getPrice();
        //then
        assertEquals(new BigDecimal(29.5), price);
    }

    @Test
    void testBaconOnionBroccoliPizzaGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        pizza = new BroccoliDecorator(pizza);
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Pizza with tomato sauce with mozzarella and bacon and onion and broccoli", description);
    }

    @Test
    void testBroccoliExtraCheesePizzaGetPrice() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BroccoliDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //when
        BigDecimal price = pizza.getPrice();
        //then
        assertEquals(new BigDecimal(25.5), price);
    }

    @Test
    void testBroccoliExtraCheesePizzaGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BroccoliDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Pizza with tomato sauce with mozzarella and broccoli and extra cheese", description);
    }
}
