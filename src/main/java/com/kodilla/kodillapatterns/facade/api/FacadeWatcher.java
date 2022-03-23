package com.kodilla.kodillapatterns.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("Logging the event start. User ID: " + userId + ", Order: " + order + ", Class: " + object.getClass().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))", throwing = "error")
    public void logEventError(JoinPoint jp, Throwable error) {
        LOGGER.info("Logging the event with the exception: " + error.toString() + ", method signature: " + jp.toShortString());
    }

    @Around("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            long timeConsumed = end - begin;
            LOGGER.info("Time consumed " + timeConsumed + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @AfterReturning("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))")
    public void logEventReturning() {
        LOGGER.info("Logging the event ended without error");
    }

    @After("execution(* com.kodilla.kodillapatterns.facade.api.OrderFacade.processOrder(..))")
    public void logEventEnd() {
        LOGGER.info("Logging the event end");
    }
}
