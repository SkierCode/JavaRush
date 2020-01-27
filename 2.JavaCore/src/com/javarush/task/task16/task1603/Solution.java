package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread st1 = new SpecialThread();
        SpecialThread st2 = new SpecialThread();
        SpecialThread st3 = new SpecialThread();
        SpecialThread st4 = new SpecialThread();
        SpecialThread st5 = new SpecialThread();

        Thread td1 = new Thread(st1);
        Thread td2 = new Thread(st2);
        Thread td3 = new Thread(st3);
        Thread td4 = new Thread(st4);
        Thread td5 = new Thread(st5);

        list.add(td1);
        list.add(td2);
        list.add(td3);
        list.add(td4);
        list.add(td5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
