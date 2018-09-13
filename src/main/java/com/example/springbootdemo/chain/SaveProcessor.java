package com.example.springbootdemo.chain;

import java.util.concurrent.LinkedBlockingDeque;

public class SaveProcessor extends Thread implements RequestProcessor{

    private static final LinkedBlockingDeque<Request> queue = new LinkedBlockingDeque();

    @Override
    public void run() {
        while (true) {
            try {
                Request request = queue.take();
                System.out.println("SaveProcessor.run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Request request) {
        queue.add(request);
    }
}
