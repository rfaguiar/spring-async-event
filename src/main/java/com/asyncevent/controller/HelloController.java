package com.asyncevent.controller;

import com.asyncevent.event.HelloEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/event")
public class HelloController {
    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    private ApplicationEventPublisher eventPublisher;

    public HelloController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @GetMapping
    public String hello() {
        LOGGER.info("call hello controller");
        eventPublisher.publishEvent(new HelloEvent("HelloController event"));
        return "Hello";
    }

}
