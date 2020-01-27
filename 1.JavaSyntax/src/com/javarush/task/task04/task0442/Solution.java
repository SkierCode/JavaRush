package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;true;){
            String sN = reader.readLine();
            int n = Integer.parseInt(sN);
            sum+=n;
            if (n==-1)
                break;
        }
        System.out.println(sum);
    }
}
