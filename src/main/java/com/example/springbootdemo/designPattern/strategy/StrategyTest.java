package com.example.springbootdemo.designPattern.strategy;

/**
 * 策略模式：上下文环境、抽象策略类、具体策略类
 * 上下文环境中引入抽象策略类，目的是传入不同的具体的策略类都能返回它的父类，自动向上转型，面向接口编程。
 * 核心就是上下文环境。
 */
public class StrategyTest {
    public static void main(String[] args) {
        AbstractStrategy abstractStrategy = new SpecificStrategyA();
        StrateryContext strateryContext = new StrateryContext(abstractStrategy);
        strateryContext.doRun();
    }
}
