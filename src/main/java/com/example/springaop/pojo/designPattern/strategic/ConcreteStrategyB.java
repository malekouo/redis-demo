package com.example.springaop.pojo.designPattern.strategic;

public class ConcreteStrategyB extends Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("坐公交出门");
    }
}
