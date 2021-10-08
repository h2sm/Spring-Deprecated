package com.example.springdeprecated;

import com.example.springdeprecated.firstTask.component.SomeClass;
import com.example.springdeprecated.firstTask.config.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringDeprecatedApplication {

    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(Configuration.class);
        var bean = x.getBean("smclass", SomeClass.class);
        bean.doSomething();
        bean.sheesh();
        second();
    }

    public static void second() {

    }

}
