package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) setShifr(args[1], args[2]);
        if (args[0].equals("-d")) setDeshifr(args[1], args[2]);
    }

    public static void setShifr (String fileName, String fileOutputName) throws IOException {
        int count;
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0){
            count = fis.read();
            fos.write(count+1);
        }
        fis.close();
        fos.close();
    }

    public static void setDeshifr (String fileName, String fileOutputName) throws IOException {
        int count;
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0){
            count = fis.read();
            fos.write(count-1);
        }
        fis.close();
        fos.close();
    }

}
