package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int max=0 , i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(i=0; i<5; i++){
            strings.add(reader.readLine());
            if (i==0) {
                max = strings.get(0).length();
            }
            if (i != 0 && strings.get(i-1).length() < strings.get(i).length())
                max=strings.get(i).length();
        }
        for (i = 0; i < strings.size(); i++){
            if (strings.get(i).length() == max)
                System.out.println(strings.get(i));
        }

    }
}
