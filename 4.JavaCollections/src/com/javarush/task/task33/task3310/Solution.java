package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
    }

    //для переданного множества строк возвращать множество идентификаторов.
    // Идентификатор для каждой отдельной строки нужно получить, используя shortener
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
//        Set<Long> ids = new HashSet<>();
//        for (String string : strings) {
//            ids.add(shortener.getId(string));
//        }
//        return ids;

        return strings.stream()
                .map(shortener::getId)
                .collect(Collectors.toSet());
    }

    //возвращать множество строк,
    // которое соответствует переданному множеству идентификаторов
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream()
                .map(shortener::getString)
                .collect(Collectors.toSet());
    }
    //тестировать работу переданной стратегии
    // на определенном количестве элементов elementsNumber
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        long startTime = new Date().getTime();
        Set<Long> ids = getIds(shortener, set);
        long endTime = new Date().getTime();
        Helper.printMessage("getIds time work is: " + (endTime - startTime) + " ms");

        startTime = new Date().getTime();
        final Set<String> strings = getStrings(shortener, ids);
        endTime = new Date().getTime();
        Helper.printMessage("getStrings time work is: " + (endTime - startTime) + " ms");

        if (set.size() == strings.size() && set.containsAll(strings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }


}
