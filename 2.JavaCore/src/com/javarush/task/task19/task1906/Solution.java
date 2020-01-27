package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());

        while (fr.ready()){
            fr.read();
            fw.write(fr.read());
        }
        fr.close();
        fw.close();
        reader.close();
    }
}
