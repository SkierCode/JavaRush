package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> mainList = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       for (int i = 0; i < 20; i++){
           mainList.add(Integer.parseInt(reader.readLine()));
           if (mainList.get(i) % 3 == 0 && (mainList.get(i) % 2 == 0)){
               list1.add(mainList.get(i));
               list2.add(mainList.get(i));
           }
           else if (mainList.get(i) % 3 == 0)
               list1.add(mainList.get(i));
           else if (mainList.get(i) % 2 == 0)
               list2.add(mainList.get(i));
           else
               list3.add(mainList.get(i));
       }
       printList(list1);
       printList(list2);
       printList(list3);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
