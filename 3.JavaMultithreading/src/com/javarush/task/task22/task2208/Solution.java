package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        params.entrySet()
                .stream()
                .filter(stringStringEntry -> (stringStringEntry.getValue() != null))
                .forEach(stringStringEntry -> sb.append(stringStringEntry.getKey())
                        .append(" = '")
                        .append(stringStringEntry.getValue())
                        .append("'")
                        .append(" and "));
        if (sb.length() == 0) return sb.toString();
        return sb.toString().substring(0, sb.length() - 5);
    }
}
