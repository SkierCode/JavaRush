package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String s, str, fileName = null;
        int part = 0;
        StringTokenizer st;
        StringBuilder sb;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, byte[]> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        byte[] buffer;

        for (s = reader.readLine(); !s.equals("end"); s = reader.readLine()) {
            sb = new StringBuilder();
            st = new StringTokenizer(s, ".");

            sb.append(st.nextToken());
            while (st.hasMoreTokens()) {
                str = st.nextToken();
                if (!str.matches("part\\d")) sb.append(".").append(str);
                else part = Integer.parseInt(str.replaceAll("\\D+", ""));
            }

            fileName = sb.toString();
            FileInputStream fis = new FileInputStream(s);
            buffer = new byte[fis.available()];
            list.add(part);
            fis.read(buffer);
            map.put(part, buffer);
            fis.close();
        }
        reader.close();
        Collections.sort(list);

        FileOutputStream fos = new FileOutputStream(fileName);
        for (Integer a : list) {
            fos.write(map.get(a));
        }
        fos.close();
    }
}
