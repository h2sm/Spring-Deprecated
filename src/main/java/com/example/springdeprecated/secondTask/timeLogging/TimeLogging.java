package com.example.springdeprecated.secondTask.timeLogging;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Aspect
@Slf4j
public class TimeLogging {//логгируем имя класса + имя метода и его время исполнения
    private TreeMap<String, Long> map = new TreeMap<>();

    //    @Before("point()")
//    public void start(JoinPoint jp) {
//        var nowTime = System.currentTimeMillis();
//        var classname = jp.getSignature().getDeclaringTypeName();
//        var methodName = jp.getSignature().getName();
//        var key = classname + "-" + methodName;
//        map.put(key, nowTime);
//    }
//
//    @After("point()")
//    public void stop(JoinPoint jp) {
//        var classname = jp.getSignature().getDeclaringTypeName();
//        var methodName = jp.getSignature().getName();
//        var key = classname + "-" + methodName;
//        if (map.containsKey(key)) {
//            var startTime = map.get(key);
//            var diff = System.currentTimeMillis() - startTime;
//            map.put(key, diff);
//        }
//        print();
//    }
//
//    private void print() {
//        map.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEach(System.out::println);
//    }
    @Around("point()")
    @SneakyThrows
    public Object timeCounter(ProceedingJoinPoint pjp) {
        String targetClass = pjp.getTarget().getClass().getSimpleName();
        String targetMethod = pjp.getSignature().getName();
        String arg = pjp.getArgs()[0].toString();
        log.info("Executing {}.{} with argument: {}", targetClass, targetMethod, arg);

        List<String> response = (List<String>) pjp.proceed();

        log.info("Method returned: {}", response);

        return response;

    }


    @Pointcut("execution(* com.example.springdeprecated.secondTask.somePackage.*.*(..))")
    public void point() {

    }


}
