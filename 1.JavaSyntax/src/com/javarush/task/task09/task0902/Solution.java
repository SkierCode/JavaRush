package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        System.out.println(method1());

     }

    public static String method1() {
        System.out.println(method2());
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String str = stackTraceElements[2].getMethodName();
        return str;
    }

    public static String method2() {
        System.out.println(method3());
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String str = stackTraceElements[2].getMethodName();
        return str;
    }

    public static String method3() {
        System.out.println(method4());
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String str = stackTraceElements[2].getMethodName();
        return str;
    }

    public static String method4() {
        System.out.println(method5());
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String str = stackTraceElements[2].getMethodName();
        return str;
    }

    public static String method5() {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String str = stackTraceElements[2].getMethodName();
        return str;
    }
}
