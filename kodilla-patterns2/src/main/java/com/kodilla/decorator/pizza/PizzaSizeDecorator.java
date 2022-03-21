package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSizeDecorator extends AbstractPizzaOrderDecorator {
    public PizzaSizeDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("5"));
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " extra large";
    }
}