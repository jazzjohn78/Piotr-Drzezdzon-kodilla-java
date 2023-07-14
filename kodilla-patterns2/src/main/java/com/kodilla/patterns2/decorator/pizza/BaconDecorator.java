package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BaconDecorator extends AbstractPizzaDecorator {
    public BaconDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and bacon";
    }
}
