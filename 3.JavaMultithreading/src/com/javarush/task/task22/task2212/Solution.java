package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.contains("[A-Za-z]")) return false;
        int len = telNumber.replaceAll("\\D", "").length();
        if (len == 12)
            return telNumber.matches("^(\\+)\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        if (len == 10)
            return telNumber.matches("^(\\d*)(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        return false;
    }

    public static void main(String[] args) {

    }
}
