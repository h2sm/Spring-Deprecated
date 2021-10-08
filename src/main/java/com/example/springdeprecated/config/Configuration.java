package com.example.springdeprecated.config;

import com.example.springdeprecated.log.DeprecatedLog;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public DeprecatedLog logging() {
        return new DeprecatedLog();
    }
}
