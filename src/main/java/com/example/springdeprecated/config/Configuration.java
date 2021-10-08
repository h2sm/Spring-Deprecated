package com.example.springdeprecated.config;

import com.example.springdeprecated.component.SomeClass;
import com.example.springdeprecated.log.DeprecatedLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

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
