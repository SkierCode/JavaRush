package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mas = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mas.length; i++)
            mas[i] = Integer.parseInt(reader.readLine());
        for (int i=0; i<mas.length/2;i++){
            int tmp = mas[i];
            mas[i] = mas[mas.length-1-i];
            mas[mas.length-1-i] = tmp;
        }
        for (int i = 0; i < mas.length; i++)
            System.out.println(mas[i]);
    }
}

