package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
        String str;

        while ((str = fr.readLine()) != null) {
            str = str.replaceAll("\\.", "!");
            fw.write(str);
            fw.write("\n");
        }
        reader.close();
        fw.close();
        fr.close();
    }
}
