package com.javarush.task.task04.task0438;

/* 
Рисуем линии
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        for(int i=0;i<=10;i++)
        {
            for(int k=0;k<10;k++){
                if(i==0 || k==0 )
                System.out.print("8");
            }
            System.out.println();
        }

    }
}
