package com.example.springaop.pojo.designPattern.adapter;

public class App {

    public static void main( String[] args ) {
//        使用特殊功能类, 即适配类
//        需要先创建一个呗适配类的对象作为参数
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
