package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Stack<Throwable> exceptions = new Stack<>();
        while (e != null) {
            exceptions.push(e);
            e = e.getCause();
        }
        while (!exceptions.empty()) {
            Throwable currentException = exceptions.pop();
            System.out
                    .println(currentException.getClass().getName() + ": " + currentException.getMessage());
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(),
                new Exception("ABC",
                        new RuntimeException("DEF",
                                new IllegalAccessException("GHI"))));
    }
}
