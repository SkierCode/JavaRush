package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Рыжков", "Иван");
        map.put("Алексеев", "Сидр");
        map.put("Шевцов", "Иван");
        map.put("Антонов", "Антон");
        map.put("Куренков", "Иван");
        map.put("Ливанов", "Петр");
        map.put("Курин", "Иван");
        map.put("Сидоров", "Сидр");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for(String s : map.values())
        {
            if(s.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for(String s : map.keySet())
        {
            if(s.equals(lastName))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
