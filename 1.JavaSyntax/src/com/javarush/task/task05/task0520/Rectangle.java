package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код

    private int left, top, width, height;

    public Rectangle(int left){
        this.left = left;
        this.top = 1;
        this.width = 4;
        this.height = 4;
    }

    public Rectangle(int left , int top){
        this.left = left;
        this.top = top;
        this.width = 4;
        this.height = 4;
    }

    public Rectangle(int left , int top,int height){
        this.left = left;
        this.top = top;
        this.width = 4;
        this.height = height;
    }

    public Rectangle(int left , int top,int width,int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
