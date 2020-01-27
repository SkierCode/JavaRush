package com.javarush.task.task08.task0814;




import java.util.HashSet;


/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<20;i++)
            set.add(i);
        return set;

    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        // напишите тут ваш код
        for (int i=0;i<set.size();i++)
            set.removeIf(Value -> Value >10);
        return set;
    }

    public static void main(String[] args) {

    }
}
