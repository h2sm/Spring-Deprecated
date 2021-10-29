package com.example.springdeprecated.secondTask.timeLogging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.*;

@Aspect
@Slf4j
public class TimeLogging {
    private static Map<String, Long> map = new TreeMap<>();

    @Around("point()")
    public Object timeCounter(ProceedingJoinPoint pjp) throws Throwable {
        String targetClass = pjp.getTarget().getClass().getSimpleName();
        String targetMethod = pjp.getSignature().getName();
        var key = targetClass + "-" + targetMethod;
        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endtime = System.currentTimeMillis();
        map.put(key, endtime - startTime);
        return obj;
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Closing....");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    @Pointcut("within(com.example.springdeprecated.secondTask.somePackage..*)")
    public void point() {

    }


}
