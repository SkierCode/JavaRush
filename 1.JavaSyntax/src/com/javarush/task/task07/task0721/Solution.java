package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum, i;
        int minimum;

        int[] mas = new int[20];  //напишите тут ваш код
        for (i=0; i<20;i++)
            mas[i] = Integer.parseInt(reader.readLine());

        maximum = minimum = mas[0];

        for (i=1;i<20;i++){
            if (mas[i]>maximum)
                maximum=mas[i];
            else if (mas[i]<minimum)
                minimum=mas[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
