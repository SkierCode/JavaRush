package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()))) {
            String[] words = fr.readLine().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words) {
        if (words==null || words.length==0) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].toLowerCase().endsWith(words[j].toLowerCase().substring(0, 1)) && list.isEmpty()) {
                    list.add(words[i]);
                    list.add(words[j]);
                    break;
                }
                else if (!list.isEmpty() && list.get(i).toLowerCase().endsWith(words[j].toLowerCase().substring(0, 1)) && !list.contains(words[j])){
                    list.add(words[j]);
                    break;
                }

            }
        }
        list.forEach(s -> sb.append(s).append(" "));
        return new StringBuilder(sb.toString().trim());
    }
}
