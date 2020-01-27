package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        String num2 = reader.readLine();
        String num3 = reader.readLine();
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int c = Integer.parseInt(num3);
        if(a==b && a!=c)
            System.out.println(a+" "+b);
        else if(b==c && b!=a)
            System.out.println(b+" "+c);
        else if(a==c && a!=b)
            System.out.println(a+" "+c);
        else if(a == b && a==c)
            System.out.println(a+" "+b+" "+c);
    }
}