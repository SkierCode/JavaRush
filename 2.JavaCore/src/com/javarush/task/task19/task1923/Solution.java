package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        StringTokenizer st;
        String str, s;
        while ((str = fr.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()) {
                s = st.nextToken();
                if (s.matches("(.*[0-9]+.*)")) {
                    fw.write(s);
                    fw.write(" ");
                }
            }
        }
        fr.close();
        fw.close();
    }
}
