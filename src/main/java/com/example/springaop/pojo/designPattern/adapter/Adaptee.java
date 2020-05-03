package com.example.springaop.pojo.designPattern.adapter;

//第二步： 这是系统中已经存在的可以使用的类，但是违背了 客户的标准
//角色：被适配的类
//已经存在的, 并且具有特殊功能的类, 但是不符合我们既有的标准的接口的类
public class Adaptee {

    //因为我这里的方法是 specificRequest名称，和标准的request不同
    public void specificRequest() {
        System.out.println("被适配类, 我是两孔插座, 具有特殊的功能");
    }
}
