package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int tmp, i, j;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[5];
        for (i = 0; i < mas.length; i++)
            mas[i] = Integer.parseInt(reader.readLine());
        for (i = 0; i < mas.length-1; i++){
            for(j = i+1; j < mas.length; j++) {
                if (mas[i] > mas[j]) {
                    tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
        for (i = 0; i < mas.length; i++)
            System.out.println(mas[i]);
        //напишите тут ваш код
    }
}
