package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int plusCount=0, minusCount=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int a = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int b = Integer.parseInt(num2);
        String num3 = reader.readLine();
        int c = Integer.parseInt(num3);
        if (a>0)
            plusCount++;
        else if (a<0)
            minusCount++;
        if (b>0)
            plusCount++;
        else if (b<0)
            minusCount++;
        if (c>0)
            plusCount++;
        else if (c<0)
            minusCount++;
        System.out.println("количество отрицательных чисел: "+minusCount);
        System.out.println("количество положительных чисел: "+plusCount);
    }
}
