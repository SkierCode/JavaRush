package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new HashMap<>();
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        StringTokenizer st;
        String name, str;
        double value, max = 0;
        while ((str = fr.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            name = st.nextToken();
            value = Double.parseDouble(st.nextToken());
            if (map.containsKey(name)) {
                value = map.get(name) + value;
                map.put(name, value);
            } else map.put(name, value);
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            value = pair.getValue();
            if (value > max) max = value;
        }
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == max) System.out.println(pair.getKey());
        }

        fr.close();
    }
}
