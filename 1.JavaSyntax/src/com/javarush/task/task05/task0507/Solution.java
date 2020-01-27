package com.javarush.task.task05.task0507;
import java.io.*;
/*
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i=0;
        float av,sum=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String sNum = reader.readLine();
            int num = Integer.parseInt(sNum);
            if (num == -1)
                break;
            sum += num;
            i++;
        }
        av = sum / i;
        System.out.println(av);
    }
}