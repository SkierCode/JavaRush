package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        int sum = a + b;
        return sum;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        int min = a - b;
        return min;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        int mul = a*b;
        return mul;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double div = a / (double)b;
        return div;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double per = (a*(double)b)/100;
        return per;
    }

    public static void main(String[] args) {


    }
}