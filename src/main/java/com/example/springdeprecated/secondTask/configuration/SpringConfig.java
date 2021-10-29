package com.example.springdeprecated.secondTask.configuration;

import com.example.springdeprecated.secondTask.somePackage.FirstClass;
import com.example.springdeprecated.secondTask.somePackage.ThirdClass;
import com.example.springdeprecated.secondTask.somePackage.TimeConsumingClass;
import com.example.springdeprecated.secondTask.timeLogging.TimeLogging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

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

    @Bean
    @Scope(value = "singleton")
    public TimeLogging tl() {
        return new TimeLogging();
    }

    @Bean
    public ThirdClass tc() {
        return new ThirdClass(fc(), tcc());
    }

}
