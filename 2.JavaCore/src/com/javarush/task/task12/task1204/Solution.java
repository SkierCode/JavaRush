package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        if(o.getClass() == Cat.class)
            System.out.println("Кошка");
        else if(o.getClass() == Dog.class)
            System.out.println("Собака");
        else if(o.getClass() == Bird.class)
            System.out.println("Птица");
        else if(o.getClass() == Lamp.class)
            System.out.println("Лампа");
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
