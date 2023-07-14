package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionDecorator extends AbstractPizzaDecorator {
    public OnionDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and onion";
    }
}
