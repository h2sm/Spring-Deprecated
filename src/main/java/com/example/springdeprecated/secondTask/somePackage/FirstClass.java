package com.example.springdeprecated.secondTask.somePackage;

import java.io.File;

public class FirstClass {
    public void saySomething() {
        System.out.println("woow");
    }

    public void loadFile() {
        var file = new File("/home/egor/someVideo.mkv");
        System.out.println(file.getPath());
    }
}
