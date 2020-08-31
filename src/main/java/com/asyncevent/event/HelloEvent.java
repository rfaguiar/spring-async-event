package com.asyncevent.event;

public class HelloEvent {

    private String event;

    public HelloEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
