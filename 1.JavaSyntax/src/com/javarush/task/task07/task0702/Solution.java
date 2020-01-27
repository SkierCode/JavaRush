package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] mas = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mas.length-2; i ++)
            mas[i] = reader.readLine();

        for (int i=0; i < mas.length/2; i++){
            String tmp = mas[i];
            mas[i] = mas[mas.length-1-i];
            mas[mas.length-1-i] = tmp;
        }

        for (int i = 0; i < mas.length; i ++)
            System.out.println(mas[i]);
    }
}