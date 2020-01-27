package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        final StringBuilder builder = new StringBuilder();
        final TreeSet<String> set = new TreeSet<>();

        while (reader.ready()) {
            builder.append(reader.readLine());
        }

        final String[] split = builder
                .toString()
                .toLowerCase()
                .replaceAll("\\W", "")
                .split("");

        set.addAll(Arrays.asList(split));

        set.stream()
                .limit(5)
                .forEach(System.out::print);
    }
}
