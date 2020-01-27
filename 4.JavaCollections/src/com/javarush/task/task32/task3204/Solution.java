package com.javarush.task.task32.task3204;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        char[] numbers = new char[10];
        char[] upperCase = new char[26];
        char[] lowerCase = new char[26];

        char[][] chars = new char[][]{numbers, lowerCase, upperCase};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (char) (i + 48);
        }
        for (int i = 0; i < upperCase.length; i++) {
            upperCase[i] = (char) (i + 65);
        }
        for (int i = 0; i < lowerCase.length; i++) {
            lowerCase[i] = (char) (i + 97);
        }

        int num;
        char[] result = new char[8];
        for (int i = 0; i < 8; i++) {
            num = (int) (Math.random() * 3);
            char[] rnd = chars[num];
            num = (int) (Math.random() * rnd.length);
            result[i] = rnd[num];
        }
        String s = String.valueOf(result);
        if(!s.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}")) return getPassword();
        outputStream.write(s.getBytes());
        return outputStream;
    }
}