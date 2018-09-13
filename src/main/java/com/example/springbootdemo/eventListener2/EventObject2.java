package com.example.springbootdemo.eventListener2;

import java.util.EventObject;

public class EventObject2 extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObject2(Object source) {
        super(source);
    }

    public void click(){
        System.out.println("EventObject2.click");
    }
}
