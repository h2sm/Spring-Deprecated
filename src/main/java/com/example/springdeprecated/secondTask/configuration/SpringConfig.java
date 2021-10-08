package com.example.springdeprecated.secondTask.configuration;

import com.example.springdeprecated.secondTask.somePackage.FirstClass;
import com.example.springdeprecated.secondTask.somePackage.ThirdClass;
import com.example.springdeprecated.secondTask.somePackage.TimeConsumingClass;
import com.example.springdeprecated.secondTask.timeLogging.TimeLogging;
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
    @Bean
    public ThirdClass tc(){
        return new ThirdClass(fc(),tcc());
    }

    @Bean
    public TimeLogging tl(){
        return new TimeLogging();
    }

}
