package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] words = string.split(" ");
        if (words.length < 5) throw new TooShortStringException();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            s.append(words[i]).append(" ");
        }
        return s.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

