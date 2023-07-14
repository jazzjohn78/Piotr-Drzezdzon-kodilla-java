package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BroccoliDecorator extends AbstractPizzaDecorator {
    public BroccoliDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and broccoli";
    }
}
