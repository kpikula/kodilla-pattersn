package com.kodilla.kodillapatterns.decorator.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class PizzaOrderTestSuite {

    @Test
    public void testPizzaOrderDelegateGetCosts() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
    }

    @Test
    public void testPizzaOrderDelegateGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();

        //When
        String pizzaDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Margherita", pizzaDescription);
    }

    @Test
    public void testSizeDecoratorDelegateGetCosts() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();
        pizzaOrder = new PizzaSizeDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(30), calculatedCost);
    }

    @Test
    public void PizzaSizeDecoratorGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();
        pizzaOrder = new PizzaSizeDecorator(pizzaOrder);

        //When
        String pizzaDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Margherita extra large", pizzaDescription);
    }

    @Test
    public void testSizeThicknessTakeAwayDecoratorDelegateGetCosts() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();
        pizzaOrder = new PizzaSizeDecorator(pizzaOrder);
        pizzaOrder = new PizzaThicknessDecorator(pizzaOrder);
        pizzaOrder = new PizzaTakeAwayDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(35.0), calculatedCost);
    }

    @Test
    public void PizzaSizeThicknessTakeAwayGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new PizzaOrderDelegate();
        pizzaOrder = new PizzaSizeDecorator(pizzaOrder);
        pizzaOrder = new PizzaThicknessDecorator(pizzaOrder);
        pizzaOrder = new PizzaTakeAwayDecorator(pizzaOrder);

        //When
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals("Margherita extra large extra thick take away", pizzaDescription);
    }
}