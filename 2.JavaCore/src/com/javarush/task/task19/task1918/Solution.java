package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String s = "Info about Leela <span xml:lang=";
        String[] words = s.split("");
        System.out.println(Arrays.toString(words));
    }
}
