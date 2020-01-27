package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int max;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int a = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int b = Integer.parseInt(num2);
        String num3 = reader.readLine();
        int c = Integer.parseInt(num3);
        String num4 = reader.readLine();
        int d = Integer.parseInt(num4);
        if (a<b)
            max = b;
        else
            max = a;
        if (max<c)
            max = c;
        if (max<d)
            max=d;
        System.out.println(max);
    }
}
