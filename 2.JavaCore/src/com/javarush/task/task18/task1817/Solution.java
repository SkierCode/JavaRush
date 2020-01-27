package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int itSpace = 0, count = 0;
        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0) {
            int data =
            count++;

            if (inputStream.read() == Integer.valueOf(' ')) itSpace++;
        }
        inputStream.close();
        System.out.printf("%.2f", ((double)itSpace/count*100));
    }
}
