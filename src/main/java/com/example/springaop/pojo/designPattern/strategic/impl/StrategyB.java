package com.example.springaop.pojo.designPattern.strategic.impl;

public class StrategyB implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("飞机出门");
    }
}
