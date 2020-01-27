package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        static volatile int myCount = count;

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if(myCount !=1){
                System.out.println(new GenerateThread());
                --myCount;
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
