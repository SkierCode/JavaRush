package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int tmp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int a = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int b = Integer.parseInt(num2);
        String num3 = reader.readLine();
        int c = Integer.parseInt(num3);
        if(b<c){
            tmp=b;
            b=c;
            c=tmp;
        }
        if(a<c){
            tmp=a;
            a=c;
            c=tmp;
        }
        if (a<b){
            tmp=a;
            a=b;
            b=tmp;
        }
        System.out.println(a+" "+b+" "+c);
    }
}
