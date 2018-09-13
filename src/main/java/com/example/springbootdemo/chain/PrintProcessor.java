package com.example.springbootdemo.chain;

import java.util.concurrent.LinkedBlockingDeque;

public class PrintProcessor extends Thread implements RequestProcessor {

    private static final LinkedBlockingDeque<Request> queue = new LinkedBlockingDeque();

    private RequestProcessor requestProcessor;

    public PrintProcessor(RequestProcessor requestProcessor){
        this.requestProcessor = requestProcessor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = queue.take();
                System.out.println("PrintProcessor.run");
                requestProcessor.process(request);
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
