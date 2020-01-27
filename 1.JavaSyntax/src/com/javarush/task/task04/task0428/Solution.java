package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int a = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int b = Integer.parseInt(num2);
        String num3 = reader.readLine();
        int c = Integer.parseInt(num3);
        if (a>0)
            count++;
        if (b>0)
            count++;
        if (c>0)
            count++;
        System.out.println(count);
    }
}
