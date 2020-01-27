package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0, cur;
        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0){
            cur = inputStream.read();
            if ((cur >= Integer.valueOf('A') && cur<= Integer.valueOf('Z')) ||
                    (cur >= Integer.valueOf('a') && cur<= Integer.valueOf('z')))
                count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
