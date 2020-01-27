package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int j=0,k=0;
        StringBuilder allVowel = new StringBuilder();
        StringBuilder allConsonant = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] words = s.toCharArray();

        for (int i=0;i<words.length;i++){
            if(words[i] == ' ')
                continue;
            if(isVowel(words[i]))
                allVowel.append(words[i]).append(' ');
            else
                allConsonant.append(words[i]).append(' ');
        }
        System.out.println(allVowel.toString());
        System.out.println(allConsonant.toString());
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}