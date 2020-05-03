package com.example.springaop.pojo.designPattern.strategic.impl;

public class ClientTest {
    public static void main(String[] args) {

        StrategyA a = new StrategyA();
        StrategyB b = new StrategyB();
        StrategyC c = new StrategyC();
        Context context = new Context();

        context.contextInterface(a);
        context.contextInterface(b);
        context.contextInterface(c);

    }
}
