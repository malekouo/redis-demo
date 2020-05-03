package com.example.springaop.pojo.designPattern.strategic.impl;

public class StrategyA implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("火车出门");
    }
}
