package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        sb.append(s.charAt(0));
        final char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (sb.toString().contains(Character.toString(chars[i]))) {
                list.add(sb.length());
                sb = new StringBuilder();
            }
            sb.append(chars[i]);
        }
        list.add(sb.length());
        return list.stream().max(Integer::compareTo).get();
    }
}
