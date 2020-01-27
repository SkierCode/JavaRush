package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int chet=0, nechet=0;
        int[] mas = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mas.length; i++){
            mas[i] = Integer.parseInt(reader.readLine());
            if (i%2 != 0)
                nechet +=mas[i];
            else
                chet += mas[i];
        }
        if (nechet>chet)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else if (chet>nechet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
