package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String sign,half;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum = reader.readLine();
        int num = Integer.parseInt(sNum);
        if (num < 0)
            sign = "отрицательное";
        else
            sign = "положительное";
        if (num % 2 == 0)
            half = "четное";
        else
            half = "нечетное";
        if (num==0)
            System.out.println("ноль");
        else
            System.out.println(sign+" "+half+" число");
    }
}
