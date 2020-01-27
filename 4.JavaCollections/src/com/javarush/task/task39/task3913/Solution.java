package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:/2/"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        System.out.println(logParser.getUniqueIPs(null, new Date()));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForUser("Vasya Pupkin",null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.LOGIN,null, new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin",null, new Date()));
        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin",15, null, null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18,null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber (null, null));
    }
}