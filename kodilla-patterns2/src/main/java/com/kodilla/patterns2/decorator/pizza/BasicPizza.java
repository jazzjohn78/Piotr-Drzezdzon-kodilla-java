package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizza implements Pizza {
    public BasicPizza() {
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "Pizza with tomato sauce with mozzarella";
    }
}
