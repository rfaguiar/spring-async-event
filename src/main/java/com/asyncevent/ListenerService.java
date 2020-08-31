package com.asyncevent;

import com.asyncevent.event.HelloEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ListenerService {

    private static final Logger LOGGER = LogManager.getLogger(ListenerService.class);

    @EventListener
    public void processHelloEvent(HelloEvent event) {
        LOGGER.info("init process HelloEvent");
        for (int i = 0; i < 10; i++) {
            LOGGER.info("HelloEvent loop index {}", i);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
    
}
