package com.javarush.task.task04.task0432;
/*
Хорошего много не бывает
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String num = reader.readLine();
        int n = Integer.parseInt(num);
        while (i<n) {
            System.out.println(s);
            i++;
        }
    }
}
