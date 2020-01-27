package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())));
        ArrayList<Long> list = new ArrayList<>();
        String s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            list.add(Math.round(Double.parseDouble(st.nextToken())));
        }


        FileWriter fw = new FileWriter(new BufferedReader(new InputStreamReader(System.in)).readLine());
        for (int i = 0; i < list.size(); i++) {
            fw.write(list.get(i) + " ");
        }

        reader.close();
        fw.close();
    }
}
