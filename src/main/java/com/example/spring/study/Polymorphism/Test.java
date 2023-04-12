package com.example.spring.study.Polymorphism;

/**
 * @author TwinkleDing
 */
public class Test {

    public static void main(String[] args) {

        Man m1 = new Man("老王",30);
        Dog d = new Dog(2, "黑色", "阿黄");
        m1.keepPet(d, "骨头");

        Man m2 = new Man("老李",40);
        Cat c = new Cat(3, "橘色", "大橘");
        m2.keepPet(c, "猫粮");

    }
}
