package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    //напишите тут ваш код
    private String name;
    private int age;
    private char sex;

    public void initialize(String friendName){
        this.name = friendName;
    }

    public void initialize(String friendName, int friendAge){
        this.name = friendName;
        this.age = friendAge;
    }

    public void initialize(String friendName, int friendAge, char friendSex){
        this.name = friendName;
        this.age = friendAge;
        this.sex = friendSex;
    }

    public static void main(String[] args) {

    }
}
