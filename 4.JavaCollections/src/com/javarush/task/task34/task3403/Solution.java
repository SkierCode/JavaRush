package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        int a = 2;
        while ( a <= n) {
            if (n % a == 0) {
                System.out.println(a);
                recurse(n / a);
                return;
            }
            a++;
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}
