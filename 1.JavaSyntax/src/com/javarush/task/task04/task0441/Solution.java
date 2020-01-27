package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum1 = reader.readLine();
        int a = Integer.parseInt(sNum1);
        String sNum2 = reader.readLine();
        int b = Integer.parseInt(sNum2);
        String sNum3 = reader.readLine();
        int c = Integer.parseInt(sNum3);
        if (a==b && b==c)
            System.out.println(a);
        else if (a==b || a==c || (a<b && a>c) || (a>b && a<c))
            System.out.println(a);
        else if (b==c || (b<a && b>c) || (b>a && b<c))
            System.out.println(b);
        else
            System.out.println(c);
    }
}
