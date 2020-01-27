package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));

        int count;
        String str;
        StringTokenizer st;

        while ((str = fr.readLine()) != null) {
            count = 0;
            String s;
            st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()) {
                s = st.nextToken();
                if (words.contains(s)) {
                    count++;
                }
            }
            if (count == 2) System.out.println(str);
        }
        reader.close();
        fr.close();
    }
}
