package com.example.springbootdemo.chain;

public class TestDemo {
    private PrintProcessor printProcessor;
    public TestDemo(){
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        Request request = new Request();
        request.setName("===");
        demo.doTest(request);
    }

    public void doTest(Request request){
        printProcessor.process(request);
    }
}
