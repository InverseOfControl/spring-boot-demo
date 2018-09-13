package com.example.springbootdemo.eventListener;

import java.util.Vector;

public class MyEventSource {
    private Vector<MyEventListener> listeners = new Vector<MyEventListener>();

    public void addListener(MyEventListener myEventListener){
        listeners.add(myEventListener);
    }

    public void envnt(MyEventObject eventObject){
        for (MyEventListener listener : listeners) {
            listener.handleEvent(eventObject);
        }
    }

}
