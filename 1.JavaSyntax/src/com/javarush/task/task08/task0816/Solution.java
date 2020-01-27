package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Natsu", df.parse("MAY 8 1990"));
        map.put("Elize", df.parse("JUNE 1 1980"));
        map.put("Sanny", df.parse("JULY 1 1980"));
        map.put("Viktor", df.parse("AUGUST 1 1980"));
        map.put("Anton", df.parse("JANUARY 20 1974"));
        map.put("Kira", df.parse("DECEMBER 25 2005"));
        map.put("Salla", df.parse("OCTOBER 11 1977"));
        map.put("Igor", df.parse("NOVEMBER 9 1984"));
        map.put("Selivan", df.parse("APRIL 2 1978"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Date> entry = iter.next();
            if (entry.getValue().getMonth() > 4 && entry.getValue().getMonth() < 8) {
                iter.remove();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
    }
}
