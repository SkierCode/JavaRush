package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++)
            list.add(Integer.parseInt(reader.readLine()));
        for (int i=0; i<list.size()/2; i++){
            int tmp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,tmp);
        }
        for (Integer s : list)
            System.out.println(s);
    }
}
