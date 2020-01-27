package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        for (s = reader.readLine(); !s.equals("exit"); s = reader.readLine()) new ReadThread(s).start();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            FileInputStream stream = null;
            Map<Integer, Integer> map = new HashMap<>();
            int cur, val, max = 0, result = 0;
            try {
                stream = new FileInputStream(fileName);
                while (stream.available() > 0) {
                    cur = stream.read();
                    if (map.containsKey(cur)) {
                        val = map.get(cur);
                        val++;
                        map.put(cur, val);
                    } else map.put(cur, 1);
                }
            } catch (IOException e) {
                try {
                    stream.close();
                } catch (IOException ex) {}
            }
            try {
                stream.close();
            } catch (IOException e) {}

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                cur = pair.getValue();
                if (cur > max) max = cur;
            }
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() == max)
                    result = pair.getKey();
            }
            resultMap.put(fileName, result);
        }
    }
}
