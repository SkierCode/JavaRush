package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;true;){
            String sNumber = reader.readLine();
            if(sNumber.equals("сумма"))
                break;
            int number = Integer.parseInt(sNumber);
            sum = sum + number;
        }
        System.out.println(sum);
    }
}
