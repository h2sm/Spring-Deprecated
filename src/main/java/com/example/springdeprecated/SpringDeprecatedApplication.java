package com.example.springdeprecated;

import com.example.springdeprecated.component.SomeClass;
import com.example.springdeprecated.config.Configuration;
import com.example.springdeprecated.log.DeprecatedLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Vector;

@SpringBootApplication
public class SpringDeprecatedApplication {

    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(Configuration.class);
        var bean = x.getBean("smclass", SomeClass.class);
        bean.doSomething();
        bean.sheesh();
    }

}
