package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int cur, max = 0, val = 0;
        while (stream.available() > 0){
            cur  = stream.read();
            if(map.containsKey(cur)){
                val = map.get(cur);
                val++;
                map.put(cur, val);
            }
            else map.put(cur, 1);
        }
        stream.close();

        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            cur = pair.getValue();
            if (cur > max) max = cur;
        }
        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if (pair.getValue() == max) sb.append(pair.getKey()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
