package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String s = result.replace("\n", "").replace("\r", "");
        String[] str = result.split(" ");
        if (str[1].equals("+"))
            s += Integer.toString(Integer.parseInt(str[0]) + Integer.parseInt(str[2]));
        else if (str[1].equals("-"))
            s += Integer.toString(Integer.parseInt(str[0]) - Integer.parseInt(str[2]));
        else if (str[1].equals("*"))
            s += Integer.toString(Integer.parseInt(str[0]) * Integer.parseInt(str[2]));
        System.out.print(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

