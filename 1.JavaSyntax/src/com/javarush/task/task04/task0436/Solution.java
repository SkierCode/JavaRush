package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int m = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int n = Integer.parseInt(num2);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++)
                System.out.print("8");
            System.out.println("");
        }

    }
}
