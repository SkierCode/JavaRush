package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] arr = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder s = new StringBuilder();
        int num = number;
        while (num > 0) {
            if (num % 3 == 0) {
                s.append("0");
                num /= 3;
            } else if (num % 3 == 1) {
                s.append("+");
                num /= 3;
            } else {
                s.append("-");
                num /= 3;
                num++;
            }
        }
        int sum = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                str.append(" + ").append(arr[i]);
                sum += arr[i];
            } else if (s.charAt(i) == '-') {
                str.append(" - ").append(arr[i]);
                sum -= arr[i];
            }
        }
        System.out.println(sum + " =" + str);
    }
}