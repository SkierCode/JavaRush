package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        if (num1 <= 0 || num2 <= 0) throw new Exception();
        System.out.println(nod(num1, num2));

    }

    private static int nod(int num1, int num2) {

        if (num2 == 0) return num1;
        return nod(num2, num1 % num2);

    }

}
