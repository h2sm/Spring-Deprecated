package com.example.springdeprecated.firstTask.config;

import com.example.springdeprecated.firstTask.component.SomeClass;
import com.example.springdeprecated.firstTask.log.DeprecatedLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@org.springframework.context.annotation.Configuration
@EnableAspectJAutoProxy
public class Configuration {
    @Bean
    public DeprecatedLog logging() {
        return new DeprecatedLog();
    }
    @Bean
    public SomeClass smclass() {
        return new SomeClass();
    }
}
