package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] mas1 = {1,2,3,4,5};
        list.add(mas1);
        int[] mas2 = {6,7};
        list.add(mas2);
        int[] mas3 = {8,9,10,11};
        list.add(mas3);
        int[] mas4 = {12,13,14,15,16,17,18};
        list.add(mas4);
        int[] mas5 = new int[0];
        list.add(mas5);

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
