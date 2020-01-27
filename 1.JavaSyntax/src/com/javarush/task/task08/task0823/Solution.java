package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] words = s.toCharArray();
        for (int i=0; i<words.length;i++){
            if (i==0 || words[i-1]==' ')
                words[i] = Character.toUpperCase(words[i]);
        }
        s = new String(words);
        System.out.println(s);
    }
}
