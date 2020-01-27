package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"мама", "мыла", "раму");
        for (int i=0; i<list.size();i+=2)
           list.add(i+1,"именно");
        for (int i=0; i<list.size();i++)
            System.out.println(list.get(i));
    }
}
