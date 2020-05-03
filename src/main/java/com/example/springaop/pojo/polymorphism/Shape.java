package com.example.springaop.pojo.polymorphism;

/**
 * 形状父类
 */
public class Shape {

    private void draw() {
        System.out.println("Shape draw()");
    }

    public void  erase(){
        System.out.println("Shape erase()");
    }

    //多态的调用展示 private（就是被final隐式修饰） 和 static修饰
    public static void main(String[] args){
        Shape shape = new Circular();
        //draw被private 修饰，也就是隐式的被final修饰，被final修饰的方法是无法被动态绑定或者子类同名方法重载的
        shape.draw();//Shape draw()
        //多态，运行时发现是 Circular 类型对象，调用自己的重载父类
        shape.erase();//Circular erase()
    }
}
