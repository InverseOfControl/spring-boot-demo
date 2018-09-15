package com.example.springbootdemo.designPattern.strategy;

public class SpecificStrategyA implements AbstractStrategy {
    @Override
    public void run() {
        System.out.println("SpecificStrategyA.run");
    }
}
