package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private float weight;
        private float height;
        private String eyeColor;

        public Human(){
            this.name = "Unknown";
        }

        public Human(String name, int age){
            this.name=name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex){
            this.name=name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, float weight){
            this.name=name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }

        public Human(String name, int age, boolean sex, float weight, float height){
            this.name=name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, int age, boolean sex, float weight, float height, String eyeColor){
            this.name=name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.eyeColor = eyeColor;
        }

        public Human(String name, int age, boolean sex, float weight, String eyeColor){
            this.name=name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.eyeColor = eyeColor;
        }

        public Human(String name, int age,  float height, String eyeColor){
            this.name=name;
            this.age = age;
            this.height = height;
            this.eyeColor = eyeColor;
        }

        public Human(String name,float height,String eyeColor){
            this.name = name;
            this.height = height;
            this.eyeColor = eyeColor;
        }

        public Human(String name,String eyeColor){
            this.name=name;
            this.eyeColor = eyeColor;
        }
    }


}
