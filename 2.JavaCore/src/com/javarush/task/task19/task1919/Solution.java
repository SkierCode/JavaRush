package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new HashMap<>();
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        StringTokenizer st;
        String name, str;
        double value;
        while ((str = fr.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            name = st.nextToken();
            value = Double.parseDouble(st.nextToken());
            if (map.containsKey(name)) {
                value = map.get(name) + value;
                map.put(name, value);
            } else map.put(name, value);
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            System.out.println(s + " " + map.get(s));
        }
        fr.close();
    }
}
