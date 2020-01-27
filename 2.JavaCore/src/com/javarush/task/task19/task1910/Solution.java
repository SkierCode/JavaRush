package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
        String str;

        while ((str = fr.readLine()) != null) {
            str = str.replaceAll("[^a-zA-Zа-яА-Я_0-9 ]", "");
            fw.write(str);
        }
        reader.close();
        fw.close();
        fr.close();
    }
}

