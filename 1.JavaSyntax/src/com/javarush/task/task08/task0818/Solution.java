package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Иванов", 200);
        map.put("Петров", 500);
        map.put("Рыжков", 150);
        map.put("Алексеев", 570);
        map.put("Шевцов", 840);
        map.put("Антонов", 330);
        map.put("Куренков", 490);
        map.put("Ливанов", 820);
        map.put("Курин", 850);
        map.put("Сидоров", 770);
        return  map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>(map);
        for(Map.Entry<String, Integer> pair : copy.entrySet()){
            if(pair.getValue()<500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}