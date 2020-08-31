package com.asyncevent.controller;

import com.asyncevent.event.HelloEvent;
import com.asyncevent.service.HelloService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    private ApplicationEventPublisher eventPublisher;
    private HelloService helloService;

    public HelloController(ApplicationEventPublisher eventPublisher, HelloService helloService) {
        this.eventPublisher = eventPublisher;
        this.helloService = helloService;
    }

    @GetMapping("/event")
    public String hello() {
        LOGGER.info("call hello event");
        eventPublisher.publishEvent(new HelloEvent("HelloController event"));
        return "Hello Event process initialized";
    }

    @GetMapping("/async")
    public String helloAsync() {
        LOGGER.info("call hello async");
        helloService.helloAsyncProcess();
        return "Hello Async process initialized";
    }

}
