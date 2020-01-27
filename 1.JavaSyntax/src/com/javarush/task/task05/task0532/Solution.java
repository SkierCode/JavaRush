package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = 0;
        for (int i = 0; i < n ; i++) {
            int a = Integer.parseInt(reader.readLine());
            if (i == 0)
                maximum = a;
            maximum = a > maximum ? a : maximum;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
