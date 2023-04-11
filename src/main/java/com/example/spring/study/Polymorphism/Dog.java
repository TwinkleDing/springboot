package com.example.spring.study.Polymorphism;

/**
 * @author TwinkleDing
 */
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(int age, String color, String name) {
        super(age, color, name);
    }

    @Override
    public void eat(String food) {
        System.out.println(this.getName() + "正在吃" + food);
    }

    public void lookHome() {
        System.out.println(this.getName() + "在看家");
    }
}
