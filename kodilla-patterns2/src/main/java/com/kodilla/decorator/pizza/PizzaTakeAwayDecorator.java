package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public class PizzaTakeAwayDecorator extends AbstractPizzaOrderDecorator {
    public PizzaTakeAwayDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("2.5"));
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " take away";
    }
}