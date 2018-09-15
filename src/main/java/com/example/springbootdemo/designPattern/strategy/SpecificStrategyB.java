package com.example.springbootdemo.designPattern.strategy;

public class SpecificStrategyB implements AbstractStrategy {
    @Override
    public void run() {
        System.out.println("SpecificStrategyB.run");
    }
}
