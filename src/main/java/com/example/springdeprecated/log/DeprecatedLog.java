package com.example.springdeprecated.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class DeprecatedLog {
    @Before("log()")
    public void logMethod(JoinPoint jp) {
        var string = jp.getSignature().getName();
        log.info("deprecated class called " + string);
    }

    @Pointcut("@annotation(java.lang.Deprecated)")
    public void log() {
    }
}