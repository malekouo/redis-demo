package com.example.springaop.pojo.designPattern.strategic;

/**
 * 策略模式：
 * 我们出门的时候会选择不同的出行方式，比如骑自行车、坐公交、坐火车、坐飞机、坐火箭等等，这些出行方式，每一种都是一个策略。
 * 再比如我们去逛商场，商场现在正在搞活动，有打折的、有满减的、有返利的等等，其实不管商场如何进行促销，说到底都是一些算法，这些算法本身只是一种策略
 * <p>
 * 应用场景：一个系统有许多类，而区分它们的只是他们直接的行为时
 * 角色： {（1）上下文类 （2）抽象策略角色 （3）}具体策略角色}
 * 1.定义上下文类，通过构造函数传入不同的策略（多态方式），来计算结果
 */
public class CashContext {
    private Strategy strategy;

    public CashContext(Strategy strategy) {
        strategy.algorithmInterface();
    }
}
