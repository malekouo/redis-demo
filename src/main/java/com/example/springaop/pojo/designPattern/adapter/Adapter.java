package com.example.springaop.pojo.designPattern.adapter;

//第三步：创建一个适配器或者叫做装饰类，将系统中已有的功能，装饰为可以满足客户标准的功能
//角色：装饰类或者适配器
// 装饰类, 直接关联被适配器类, 同时实现标准接口
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.specificRequest();
    }
}
