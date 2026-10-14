package com.enthuzd.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.time.Instant;

public class ApplicationLifeCycleObserver {

    private static final Logger logger =
            LoggerFactory.getLogger(ApplicationLifeCycleObserver.class);

    @EventListener
    public void onApplicationStarted(ApplicationStartedEvent event) {
        logger.info(
                "Application started at {} | Context: {} | Time taken: {} ms",
                Instant.ofEpochMilli(event.getTimestamp()),
                event.getApplicationContext().getId(),
                event.getTimeTaken() != null
                        ? event.getTimeTaken().toMillis()
                        : "unknown"
        );
    }

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        logger.info(
                "Application is ready at {} | Context: {} | Time taken: {} ms",
                Instant.ofEpochMilli(event.getTimestamp()),
                event.getApplicationContext().getId(),
                event.getTimeTaken() != null
                        ? event.getTimeTaken().toMillis()
                        : "unknown"
        );
    }

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        logger.info(
                "Application context refreshed at {} | Context: {} | Source: {}",
                Instant.ofEpochMilli(event.getTimestamp()),
                event.getApplicationContext().getId(),
                event.getSource().getClass().getName()
        );
    }

    @EventListener
    public void onContextClosed(ContextClosedEvent event) {
        logger.info(
                "Application context is closing at {} | Context: {} | Source: {}",
                Instant.ofEpochMilli(event.getTimestamp()),
                event.getApplicationContext().getId(),
                event.getSource().getClass().getName()
        );
    }
}