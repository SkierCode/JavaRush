package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread td = new TestThread();
        td.start();
        Thread.sleep(5000);
        td.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends  Thread {
        int count =1;
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Работа потока была прервана");
                    break;
                }
            }
        }
    }
}