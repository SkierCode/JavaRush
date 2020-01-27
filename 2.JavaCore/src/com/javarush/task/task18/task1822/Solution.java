package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s;
        StringTokenizer st;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        while ((s = reader.readLine()) != null) {
            st = new StringTokenizer(s, " ");
            if (st.nextToken().equals(args[0])) {
                System.out.println(s);
            }
        }
        reader.close();
    }
}
