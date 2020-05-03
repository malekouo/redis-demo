package com.example.springaop.pojo.designPattern.strategic.extend;

public class ConcreteStrategyB extends Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("坐公交出门");
    }
}
