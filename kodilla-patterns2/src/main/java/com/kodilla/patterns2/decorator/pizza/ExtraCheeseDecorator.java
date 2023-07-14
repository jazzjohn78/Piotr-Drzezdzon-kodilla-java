package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends AbstractPizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and extra cheese";
    }
}
