package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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
        return  map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy1 = new HashMap<String, String>(map);
        HashMap<String, String> copy2 = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair1: copy1.entrySet())
        {
            int count = 0;
            for (Map.Entry<String, String> pair2: copy2.entrySet()) {
                if (pair1.getValue().equals(pair2.getValue())) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, pair1.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
