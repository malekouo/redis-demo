package com.example.springaop.pojo.designPattern.strategic.impl;

//上下文类
public class Context {
    //strategy 可以指向所有实现他的类也可以指向实现他的类的子类（多态）
    public void contextInterface(Strategy strategy) {
        strategy.algorithmInterface();
    }

}
