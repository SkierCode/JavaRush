package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    //напишите тут ваш код
    private String name, color;
    private int height;

    public void initialize(String dogName){
        this.name = dogName;
    }

    public void initialize(String dogName, int dogHeight){
        this.name = dogName;
        this.height = dogHeight;
    }

    public void initialize(String dogName, int dogHeight, String dogColor) {
        this.name = dogName;
        this.color = dogColor;
        this.height = dogHeight;
    }

    public static void main(String[] args) {

    }
}
