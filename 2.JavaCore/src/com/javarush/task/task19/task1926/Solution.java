package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb;
        String str;

        while ((str = fr.readLine()) != null) {
            sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        }

        reader.close();
        fr.close();
    }
}
