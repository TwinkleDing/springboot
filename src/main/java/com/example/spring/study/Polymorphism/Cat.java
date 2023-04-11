package com.example.spring.study.Polymorphism;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(int age, String color, String name) {
        super(age, color, name);
    }

    @Override
    public void eat(String food) {
        System.out.println(this.getName() + "正在吃" + food);
    }

    public void catchMouse() {
        System.out.println(this.getName() + "正在抓老鼠");
    }
}
