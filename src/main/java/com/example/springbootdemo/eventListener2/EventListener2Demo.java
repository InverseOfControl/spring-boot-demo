package com.example.springbootdemo.eventListener2;

public class EventListener2Demo {
    public static void main(String[] args) {
        EventSource2 eventSource2 = new EventSource2();
        eventSource2.addListener(new EventListener2() {
            @Override
            public void handleEvent(EventObject2 eventObject) {
                System.out.println(eventObject.getSource());
            }
        });
        eventSource2.invoke(new EventObject2("click1"));
    }
}
