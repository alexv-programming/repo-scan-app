package com.exercise.reposcanms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class FlowTrackingLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(FlowTrackingLoggingAspect.class);


    @Around("execution(* com.exercise.reposcanms.*.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String clazz = joinPoint.getTarget().getClass().getSimpleName();

        Object[] args = joinPoint.getArgs();

        String message= String.format("AOPlogs. Starting call of: %s.%s(%s).", clazz, method, argsToString(args));

        logger.info(message);

        try {
            Object result = joinPoint.proceed();
            logger.info(String.format("AOPlogs. Success to execute method with result: %s", result));//object link

            return result;
        } catch (Throwable e) {
            logger.error(String.format("AOPlogs. Failed to execute method: %s.%s(%s).", clazz, method, argsToString(args)));
            throw e;
        }

    }

    private String argsToString(Object[] args) {
        return Arrays.stream(args).map(String::valueOf).collect(Collectors.joining(","));
    }

}
