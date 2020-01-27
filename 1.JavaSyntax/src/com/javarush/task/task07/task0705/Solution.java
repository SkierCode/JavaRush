package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] array = new int[20];
        int[] mas1 = new int[10];
        int[] mas2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }
        mas1 = Arrays.copyOfRange(array, 0, array.length/2-1);
        mas2 = Arrays.copyOfRange(array, array.length/2, array.length);
        for(int i = 0; i < mas2.length; i++)
            System.out.println(mas2[i]);
    }
}
