package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int[] numbers = new int[s.length()];
        int result = 0;
        final String[] roman = s.split("");
        for (int i = 0; i < roman.length; i++) {
            switch (roman[i]) {
                case "I":
                    numbers[i] = 1;
                    break;
                case "V":
                    numbers[i] = 5;
                    break;
                case "X":
                    numbers[i] = 10;
                    break;
                case "L":
                    numbers[i] = 50;
                    break;
                case "C":
                    numbers[i] = 100;
                    break;
                case "D":
                    numbers[i] = 500;
                    break;
                case "M":
                    numbers[i] = 1000;
                    break;
            }
        }
        result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) {
                result += numbers[i] - numbers[i - 1] * 2;
            } else {
                result += numbers[i];
            }
        }
        return result;
    }
}
