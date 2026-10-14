package com.enthuzd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@AutoConfiguration
public class ControllersAutoConfiguration {

    private static final Logger logger =
            LoggerFactory.getLogger(ControllersAutoConfiguration.class);

    @Bean
    public ApplicationRunner restControllersCount(ApplicationContext applicationContext) {
        return args -> {
            int restControllerCount = 0, mvcControllerCount  = 0;
            for (String beanName : applicationContext.getBeanDefinitionNames()) {
                Class<?> beanType = applicationContext.getType(beanName);
                if (beanType != null && beanType.isAnnotationPresent(RestController.class)) {
                    restControllerCount++;
                }
                if (beanType != null && beanType.isAnnotationPresent(Controller.class)){
                    mvcControllerCount++;
                }
            }

            logger.info("RestController count is {}", restControllerCount);
            logger.info("MVC count is {}", mvcControllerCount);
        };
    }


}