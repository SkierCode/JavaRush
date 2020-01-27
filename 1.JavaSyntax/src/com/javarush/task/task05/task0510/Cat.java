package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name, address, color;
    private int age, weight;

    public void initialize (String catName){
        this.name = catName;
        this.age = 5;
        this.weight = 5;
        this.color = "Red";
    }

    public void initialize(String catName, int catWeight, int catAge){
        this.name = catName;
        this.age = catAge;
        this.weight = catWeight;
        this.color = "Blue";
    }

    public void initialize(String catName, int catAge){
        this.name = catName;
        this.age = catAge;
        this.weight = 4;
        this.color = "Yellow";
    }

    public void initialize(int catWeight, String catColor){
        this.age = 4;
        this.weight = catWeight;
        this.color = catColor;
    }

    public void initialize(int catWeight, String catColor, String catAdress){
        this.age = 3;
        this.weight = catWeight;
        this.color = catColor;
        this.address = catAdress;
    }

    public static void main(String[] args) {

    }
}
