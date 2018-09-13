package com.example.springbootdemo.eventListener;


/**
 * Java的事件监听机制涉及到事件源，事件监听器，事件对象三个组件,监听器一般是接口，用来约定调用方式。
 * 当事件源对象上发生操作时，它将会调用事件监听器的一个方法，并在调用该方法时传递事件对象过去。
 * 事件监听器实现类,通常是由开发人员编写，开发人员通过事件对象拿到事件源，从而对事件源上的操作进行处理。
 *
 * 按钮-事件源
 * 点击-事件对象
 * 事件监听器监听事件，监听到的事件通过事件源传递到监听器中。
 *
 */
public class EventListenerDemo {

    public static void main(String[] args) {
        MyEventSource eventSource = new MyEventSource();
        eventSource.addListener(new MyEventListener() {
            @Override
            public void handleEvent(MyEventObject object) {

                System.out.println(object.getSource());
                object.doEvent();
            }
        });
        eventSource.envnt(new MyEventObject("点击"));
    }
}
