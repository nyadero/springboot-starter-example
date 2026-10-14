package com.enthuzd.config;

import com.enthuzd.lifecycle.ApplicationLifeCycleObserver;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.server.GracefulShutdownResult;
import org.springframework.boot.web.server.context.WebServerGracefulShutdownLifecycle;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ApplicationLifeCycleConfig {

    @Bean
    public ApplicationLifeCycleObserver applicationLifeCycleObserver() {
        return new ApplicationLifeCycleObserver();
    }

}