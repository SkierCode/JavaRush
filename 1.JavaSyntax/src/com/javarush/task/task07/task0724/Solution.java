package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human oldhuman1 = new Human("Katya", false, 55);
        Human oldhuman2 = new Human("Andrey", true, 65);
        Human oldhuman3 = new Human("Janna", false, 44);
        Human oldhuman4 = new Human("Dmitry", true, 50);
        Human younghuman1 = new Human("Sergey", true, 2, oldhuman2, oldhuman1);
        Human younghuman2 = new Human("Gena", true, 5, oldhuman4,oldhuman3);
        Human younghuman3 = new Human("Danna", false,4, oldhuman2, oldhuman1);
        Human younghuman4 = new Human("Erza", false, 7, oldhuman2, oldhuman1);
        Human younghuman5 = new Human("Patrik", true, 6, oldhuman4,oldhuman3);

        System.out.println(oldhuman1);
        System.out.println(oldhuman2);
        System.out.println(oldhuman3);
        System.out.println(oldhuman4);
        System.out.println(younghuman1);
        System.out.println(younghuman2);
        System.out.println(younghuman3);
        System.out.println(younghuman4);
        System.out.println(younghuman5);
    }

    public static class Human {
        // напишите тут ваш код

        private String name;
        private boolean sex;
        private int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}