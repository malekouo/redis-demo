package com.example.springaop.pojo.designPattern.strategic;

/**
 * 测试
 */
public class Client {
    public static void main(String[] args) {
        //打车出门
        CashContext cashContext = new CashContext(new ConcreteStrategyA());
        //公交出门
        CashContext cashContext2 = new CashContext(new ConcreteStrategyB());
    }

}
