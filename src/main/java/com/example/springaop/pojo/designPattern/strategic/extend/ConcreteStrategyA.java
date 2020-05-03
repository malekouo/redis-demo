package com.example.springaop.pojo.designPattern.strategic.extend;

public class ConcreteStrategyA extends Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("打车出门");
    }
}
