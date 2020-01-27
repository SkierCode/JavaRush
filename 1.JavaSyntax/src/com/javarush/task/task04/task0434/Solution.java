package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1, n = 2;
        while(i<11) {
            System.out.print(i + " ");
            while (n < 11) {
                System.out.print(i * n + " ");
                n++;
            }
            i++;
            n=2;
            System.out.println("");
        }
    }
}
