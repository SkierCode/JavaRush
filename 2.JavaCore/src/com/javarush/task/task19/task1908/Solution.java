package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m;
        String str;

        while ((str = fr.readLine()) != null) {
            m = p.matcher(str);
            System.out.println(str);
            while (m.find()) {
                fw.write(m.group());
                fw.write(" ");
            }
        }
        reader.close();
        fw.close();
        fr.close();
    }
}
