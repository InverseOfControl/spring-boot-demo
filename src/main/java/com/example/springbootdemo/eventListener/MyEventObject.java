package com.example.springbootdemo.eventListener;

import java.util.EventObject;

public class MyEventObject extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEventObject(Object source) {
        super(source);
    }

    public void doEvent(){
        System.out.println("点击事件来了");
    }
}
