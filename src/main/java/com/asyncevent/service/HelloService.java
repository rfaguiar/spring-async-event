package com.asyncevent.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HelloService {
    private static final Logger LOGGER = LogManager.getLogger(HelloService.class);

    @Async
    public void helloAsyncProcess() {
        LOGGER.info("init process async");
        for (int i = 0; i < 10; i++) {
            LOGGER.info("HelloAsync loop index {}", i);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

}
