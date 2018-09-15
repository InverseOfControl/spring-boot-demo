package com.example.springbootdemo.designPattern.strategy;

public class StrateryContext {

    private AbstractStrategy abstractStrategy;

    public StrateryContext(AbstractStrategy abstractStrategy){
        this.abstractStrategy = abstractStrategy;
    }

    public void doRun(){
        abstractStrategy.run();
    }

}
