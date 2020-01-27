package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import com.sun.webkit.SimpleSharedBufferInputStream;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int a = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int b = Integer.parseInt(num2);
        String num3 = reader.readLine();
        int c = Integer.parseInt(num3);
        if (a!=b && a==c)
            System.out.println("2");
        else if (b!=c && a==b)
            System.out.println("3");
        else if (a!=c && b==c)
            System.out.println("1");
    }
}
