package com.example.springaop.pojo.polymorphism;

public class Circular extends Shape {

    public void draw() {
        System.out.println("Circular draw()");
    }

    public void erase() {
        System.out.println("Circular erase()");
    }
}
