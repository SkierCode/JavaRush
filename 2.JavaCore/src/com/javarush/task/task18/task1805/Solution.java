package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int num;

        while (inputStream.available() > 0){
            num = inputStream.read();
            if (!list.contains(num)) list.add(num);
        }
        inputStream.close();
        Collections.sort(list);
        for (Integer l: list) {
            builder.append(l).append(" ");
        }
        System.out.println(builder.toString());
    }
}
