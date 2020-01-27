package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        int min=0 , i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(i=0; i<5; i++){
            strings.add(reader.readLine());
            if (i==0) {
                min = strings.get(0).length();
            }
            if (i != 0 && strings.get(i-1).length() > strings.get(i).length())
                min=strings.get(i).length();
        }
        for (i = 0; i < strings.size(); i++){
            if (strings.get(i).length() == min)
                System.out.println(strings.get(i));
        }
    }
}
