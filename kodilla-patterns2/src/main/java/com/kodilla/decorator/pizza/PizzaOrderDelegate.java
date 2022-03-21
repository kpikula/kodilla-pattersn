package com.kodilla.decorator.pizza;

import java.math.BigDecimal;

public class PizzaOrderDelegate implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal("25");
    }
    @Override
    public String getDescription() {
        return "Margherita";
    }
}
