package com.javarush.task.task05.task0514;

/* 
Программист создает человека
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Person person = new Person();
        person.initialize("Vasya", 13);
    }

    static class Person {
        //напишите тут ваш код
        private String name;
        private int age;

        public void initialize(String persName, int persAge){
            this.name = persName;
            this.age = persAge;
        }
    }
}
