package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;
        int flag = 0;

        while ((str = fr.readLine()) != null){
            st = new StringTokenizer(str, " ");


            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (s.length() > 6) {
                    if (flag == 0) {
                        flag++;
                        sb.append(s);
                    } else sb.append(",").append(s);
                }
            }
        }
        str = sb.toString();
        fw.write(str);

        fr.close();
        fw.close();
    }
}
