package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        char[] ch;
        short find;
        for (s = reader.readLine();!"exit".equals(s);s = reader.readLine() ){
            find = 0;
            ch = s.toCharArray();
            if(s.matches("-?\\d+(\\.\\d+)?")) {
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == '.') {
                        print(Double.parseDouble(s));
                        find = 1;
                    }
                }
                if (find == 1) continue;
                if (Integer.parseInt(s) < 128 && Integer.parseInt(s) > 0) {
                    print(Short.parseShort(s));
                    find = 1;
                } else if (Integer.parseInt(s) >= 128 || Integer.parseInt(s) <= 0) {
                    print(Integer.parseInt(s));
                    find = 1;
                }
                if (find == 1) continue;
            }
            else print(s);
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
