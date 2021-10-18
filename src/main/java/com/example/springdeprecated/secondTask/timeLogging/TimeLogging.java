package com.example.springdeprecated.secondTask.timeLogging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import java.util.*;

@Aspect
@Slf4j
public class TimeLogging {//логгируем имя класса + имя метода и его время исполнения
    private static Map<String, Long> map = new TreeMap<>();

    @After("point()")
    private void print() {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
        System.out.println(map.size());
    }
    @Around("point()")
    public Object timeCounter(ProceedingJoinPoint pjp) throws Throwable {
        String targetClass = pjp.getTarget().getClass().getSimpleName();
        String targetMethod = pjp.getSignature().getName();
        var key = targetClass + "-" + targetMethod;
        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endtime = System.currentTimeMillis();
        map.put(key,endtime-startTime);
        return obj;
    }


    //@Pointcut("execution(* com.example.springdeprecated.secondTask.somePackage.*.*(..))")
    @Pointcut("within(com.example.springdeprecated.secondTask.somePackage..*)")
    public void point() {

    }


}
