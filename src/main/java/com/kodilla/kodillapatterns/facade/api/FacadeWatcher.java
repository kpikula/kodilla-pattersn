package com.kodilla.kodillapatterns.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))" + "&& args(userId, order)")
    public void logEventStart(OrderDto order, Long userId) {
        LOGGER.info("Logging the event start " + order.getItems().toArray() + "userId: " + userId);
    }

    @Before("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))" + "&& target(object)")
    public void logEventStart1(Object object) {
        LOGGER.info("Class: " + object.getClass().getName());
    }

    @Before("execution(* com.kodilla.kodillapatterns.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) && target(object)")
    public void logEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @AfterThrowing(pointcut = "execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))", throwing = "error")
    public void logEventError(JoinPoint jp, Throwable error) {
        LOGGER.info("Exception: " + error.toString() + " Method signature: " + jp.toShortString());
    }

    @AfterReturning("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))")
    public void logEventReturning() {
        LOGGER.info("Logging the event ended with not error");
    }

    @After("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))")
    public void logEventEnd() {
        LOGGER.info("Logging the event end");
    }
}
