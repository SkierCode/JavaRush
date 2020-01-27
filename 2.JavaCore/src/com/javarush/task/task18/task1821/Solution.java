package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cur, val;
        while (stream.available() > 0) {
            cur = stream.read();
            if (map.containsKey(cur)) {
                val = map.get(cur);
                val++;
                map.put(cur, val);
            } else map.put(cur, 1);
        }
        stream.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }

        Collections.sort(list);

        for (Integer l : list) {
            System.out.println((char) (int) l + " " + map.get(l));
        }
    }
}
