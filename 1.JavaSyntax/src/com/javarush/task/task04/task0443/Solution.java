package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sName = reader.readLine();
        String sYear = reader.readLine();
        int y = Integer.parseInt(sYear);
        String sMounth = reader.readLine();
        int m = Integer.parseInt(sMounth);
        String sDay = reader.readLine();
        int d = Integer.parseInt(sDay);
        System.out.println("Меня зовут "+sName+".");
        System.out.println("Я родился "+d+"."+m+"."+y);
    }
}
