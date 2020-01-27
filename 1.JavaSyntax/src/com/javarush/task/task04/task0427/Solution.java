package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        int a = Integer.parseInt(num);
        int len = num.length();
        if (a%2==0 && len==1 && a>0 && a<1000)
            System.out.println("четное однозначное число");
        if (a%2!=0 && len==1 && a>0 && a<1000)
            System.out.println("нечетное однозначное число");
        if (a%2==0 && len==2 && a>0 && a<1000)
            System.out.println("четное двузначное число");
        if (a%2!=0 && len==2 && a>0 && a<1000)
            System.out.println("нечетное двузначное число");
        if (a%2==0 && len==3 && a>0 && a<1000)
            System.out.println("четное трехзначное число");
        if (a%2!=0 && len==3 && a>0 && a<1000)
            System.out.println("нечетное трехзначное число");
    }
}
