package com.javarush.task.task26.task2601;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        int mediana = len % 2 != 0 ? array[len / 2] : ((array[len / 2] + array[len / 2 - 1]) / 2);

        Comparator<Integer> comparator = Comparator.comparingInt(o -> Math.abs(o - mediana));

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.sort(comparator);
        return list.toArray(new Integer[0]);
    }
}
