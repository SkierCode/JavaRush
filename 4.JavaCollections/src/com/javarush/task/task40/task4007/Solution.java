package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        SimpleDateFormat sdf = null;
        if (date.contains(" ")) {
            sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        }
        if (date.contains(".") && !date.contains(":")) {
            sdf = new SimpleDateFormat("dd.MM.yyyy");
        }
        if (date.contains(":")) {
            sdf = new SimpleDateFormat("hh:mm:ss");
        }
        if (sdf == null) return;
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH));
    }
}
