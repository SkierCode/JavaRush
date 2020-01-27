package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int count=1, result=1;
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        list.add(x);
        for (int i=1; i<10;i++){
            x = Integer.parseInt(reader.readLine());
            list.add(x);
            if (list.get(i).equals(list.get(i-1)) ){
               count++;
               if (result<count) result=count;
            }
            else
                count=1;

        }
        System.out.println(result);
    }
}