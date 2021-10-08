package com.example.springdeprecated.secondTask.timeLogging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.TreeMap;

@Aspect
public class TimeLogging {//логгируем имя класса + имя метода и его время исполнения
    private TreeMap<String, Long> map = new TreeMap<>();

    @Before("point()")
    public void start(JoinPoint jp) {
        var nowTime = System.currentTimeMillis();
        var classname = jp.getSignature().getDeclaringTypeName();
        var methodName = jp.getSignature().getName();
        var key = classname + "-" + methodName;
        map.put(key, nowTime);
    }

    @After("point()")
    public void stop(JoinPoint jp) {
        var classname = jp.getSignature().getDeclaringTypeName();
        var methodName = jp.getSignature().getName();
        var key = classname + "-" + methodName;
        if (map.containsKey(key)){
            var startTime = map.get(key);
            var diff = System.currentTimeMillis() - startTime;
            map.put(key,diff);
        }
        print();
    }

    private void print(){
        System.out.println(map.size());
        map.values().stream().sorted().forEach(System.out::println);
        //map.forEach((k,v) -> System.out.println("Class: " + k + " took " + v + " ms."));
    }

    @Pointcut("execution(* com.example.springdeprecated.secondTask.somePackage.*.*(..))")
    public void point() {

    }
}
