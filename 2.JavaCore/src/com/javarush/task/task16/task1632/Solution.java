package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread2();
        Thread thread3 = new MyThread3();
        Thread thread4 = new MyThread4();
        Thread thread5 = new MyThread5();

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);
    }

    public static void main(String[] args) {

    }

    public static class MyThread1 extends Thread{
        @Override
        public void run() { while (true){} }
    }

    public static class MyThread2 extends Thread{
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");}
        }
    }

    public static class MyThread3 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message{
        private boolean warning = false;
        @Override
        public void run() {
            while (!warning) {}
        }
        @Override
        public void showWarning() {
            warning = true;
        }
    }

    public static class MyThread5 extends Thread{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String s;

        @Override
        public void run() {
            while (true){
                try {
                    s = reader.readLine();
                    if(s.equals("N")) break;
                    sum += Integer.parseInt(s);
                    } catch (IOException e) {e.printStackTrace();}
            }
            System.out.println(sum);
        }
    }
}