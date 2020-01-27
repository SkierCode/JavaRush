package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        StringBuilder sb;
        String str;
        while ((str = fr.readLine()) != null) {
            sb = new StringBuilder();
            String[] words = str.split(" ");
            sb.append(words[0]);
            for (int i = 1; i < words.length - 3; i++)
                sb.append(" ").append(words[i]);
            Calendar calendar = new GregorianCalendar(Integer.parseInt(words[words.length - 1]),
                    Integer.parseInt(words[words.length - 2]) - 1,
                    Integer.parseInt(words[words.length - 3]));

            PEOPLE.add(new Person(sb.toString(), calendar.getTime()));
        }
        fr.close();
    }
}
