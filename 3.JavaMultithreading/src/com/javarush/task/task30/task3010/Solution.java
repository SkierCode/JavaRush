package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        for (int i = 2; i <= 36; i++) {
            try {
                String s = args[0].toUpperCase();
                Pattern p = Pattern.compile("\\W");
                Matcher m = p.matcher(s);
                if (m.find()) {
                    System.out.println("incorrect");
                    break;
                }
                new BigInteger(s, i);
                System.out.println(i);
                break;
            } catch (Exception e) {
                continue;
            }
        }
    }
}