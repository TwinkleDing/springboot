package com.example.spring.study.Polymorphism;

/**
 * @author TwinkleDing
 */
public class Man {

    private String name;
    private int age;

    public Man() {
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void keepPet(Animal animal, String food) {
        if (animal instanceof Cat cat) {
            System.out.println("年龄为" + this.age + "岁的" + this.name + "饲养了一只" + cat.getColor() + "的" + cat.getAge() + "的猫，并且起名叫" + cat.getName());
            cat.eat(food);
        } else if (animal instanceof Dog dog) {
            System.out.println("年龄为" + this.age + "岁的" + this.name + "饲养了一只" + dog.getColor() + "的" + dog.getAge() + "的狗，并且起名叫" + dog.getName());
            dog.eat(food);
        } else {
            System.out.println(this.name + "没有养宠物");
        }
    }

}
