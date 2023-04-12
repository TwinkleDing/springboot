package com.example.spring.study.Polymorphism;

/**
 * @author TwinkleDing
 */
public abstract class Animal {

    private int age;
    private String color;
    private String name;

    public Animal() {
    }

    public Animal(int age, String color, String name) {
        this.age = age;
        this.color = color;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 动物吃东西
     * @param food 食物
     */
    public abstract void eat(String food);
}
