package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader(new FileReader(reader.readLine()));
        Pattern p = Pattern.compile("\\bworld\\b");
        String str;
        Matcher m;

        int count = 0;
        while ((str = reader.readLine()) != null) {
            m = p.matcher(str);
            while (m.find()) {
                count++;
            }
        }

        System.out.println(count);
        reader.close();
    }
}
