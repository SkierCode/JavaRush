package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        Object obj = new Date();
        Long zlong = (Long) obj;
    }

    public void methodThrowsNullPointerException() {
        Integer a = null;
        final byte b = a.byteValue();
    }

    public static void main(String[] args) {

    }
}
