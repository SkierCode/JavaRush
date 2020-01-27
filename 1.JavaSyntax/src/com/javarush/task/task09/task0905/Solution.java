package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

import java.util.FormatFlagsConversionMismatchException;

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElement =  Thread.currentThread().getStackTrace();
        int count = 0;
        for (StackTraceElement traceElement : stackTraceElement){
            count++;
        }
        System.out.println(count);
        return count;
    }
}

