package com.example.springbootdemo.eventListener;

import java.util.EventListener;

public interface MyEventListener extends EventListener {
    void handleEvent(MyEventObject object);
}
