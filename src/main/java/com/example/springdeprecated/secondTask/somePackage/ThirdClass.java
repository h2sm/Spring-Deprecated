package com.example.springdeprecated.secondTask.somePackage;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class ThirdClass {
    private final FirstClass fc;
    private final TimeConsumingClass tcc;
    private final Scanner sc = new Scanner(System.in);

    public void doThis() {
        fc.saySomething();
        fc.loadFile();
        tcc.doSomethingTimeConsuming(takeTime());
    }

    private int takeTime() {
        System.out.println("input any integer for having fun");
        return sc.nextInt();
    }
}
