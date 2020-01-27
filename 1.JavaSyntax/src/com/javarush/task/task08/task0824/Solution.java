package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Andrey", 5, true);
        Human child2 = new Human("Nastya", 7, false);
        Human child3 = new Human("Lena", 3, false);
        Human mother = new Human("Tanya", 33, false, child1, child2, child3);
        Human father = new Human("Kolya", 34, true, child1, child2, child3);
        Human grandFather1 = new Human("Tolya", 64, true, father);
        Human grandMother1 = new Human("Zoya", 62, false, father);
        Human grandFather2 = new Human("Pasha", 67, true, mother);
        Human grandMother2 = new Human("Glasha", 65, false, mother);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public int age;
        public boolean sex;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name,int age,boolean sex){
            this.name=name;
            this.age=age;
            this.sex=sex;
        }

        public Human(String name,int age,boolean sex, Human...h){
            this.name=name;
            this.age=age;
            this.sex=sex;
            for(Human k : h)
            children.add(k);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
