package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1., "Odin");
        labels.put(2., "Dva");
        labels.put(3., "Tri");
        labels.put(4., "Cetire");
        labels.put(5., "Pyat");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
