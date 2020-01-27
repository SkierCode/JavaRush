package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        byte[] bytes = new byte[text.length()];

        raf.seek(number);
        raf.read(bytes, 0, text.length());

        String result = new String(bytes);
        raf.seek(raf.length());

        if (result.equals(text)) {
            raf.write("true".getBytes());
        } else raf.write("false".getBytes());
    }
}
