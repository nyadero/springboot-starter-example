package com.enthuzd.config;

import com.enthuzd.HelloService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class HelloServiceAutoConfig {

    @PostConstruct
    public void init() {
        System.out.println("Hello Service is up and running!!!!!!");
    }


    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
