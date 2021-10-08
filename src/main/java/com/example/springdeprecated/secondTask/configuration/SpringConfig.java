package com.example.springdeprecated.secondTask.configuration;

import com.example.springdeprecated.secondTask.somePackage.FirstClass;
import com.example.springdeprecated.secondTask.somePackage.TimeConsumingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
    @Bean
    public FirstClass fc() {
        return new FirstClass();
    }

    @Bean
    public TimeConsumingClass tcc() {
        return new TimeConsumingClass();
    }
}
