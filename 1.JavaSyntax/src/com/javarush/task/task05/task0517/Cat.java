package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

import java.security.PublicKey;

public class Cat {
    //напишите тут ваш код
    private String name=null, address = null, color;
    private int age, weight;

    public Cat(String name){
        this.name = name;
        this.weight = 4;
        this.age = 3;
        this.color = "Green";
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Yellow";
    }

    public Cat(String name, int age){
        this.name = name;
        this.weight = 4;
        this.age = age;
        this.color = "Red";
    }

    public Cat(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 3;
    }

    public Cat(int weight, String color, String address){
        this.age = 2;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
