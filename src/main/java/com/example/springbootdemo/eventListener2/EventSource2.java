package com.example.springbootdemo.eventListener2;

import java.util.ArrayList;
import java.util.List;

public class EventSource2 {
    private List<EventListener2> listener2List = new ArrayList<>();

    public void addListener(EventListener2 eventListener2){
        listener2List.add(eventListener2);
    }

    public void invoke(EventObject2 eventObject2){
        for (EventListener2 listener2 : listener2List) {
            listener2.handleEvent(eventObject2);
        }
    }
}
