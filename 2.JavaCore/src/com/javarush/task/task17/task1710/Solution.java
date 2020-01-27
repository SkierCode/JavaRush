package com.javarush.task.task17.task1710;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        int id;
        String name, sex, date;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            name = args[1];
            sex = args[2];
            date = args[3];
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, sdf.parse(date)));
            else if (sex.equals("ж"))
                allPeople.add(Person.createFemale(name, sdf.parse(date)));
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-u")) {
            id = Integer.parseInt(args[1]);
            name = args[2];
            sex = args[3];
            date = args[4];
            if (sex.equals("м"))
                allPeople.set(id, Person.createMale(name, sdf.parse(date)));
            else if (sex.equals("ж"))
                allPeople.set(id, Person.createFemale(name, sdf.parse(date)));
        } else if (args[0].equals("-d")) {
            id = Integer.parseInt(args[1]);
            Person p = allPeople.get(id);
            p.setName(null);
            p.setBirthDate(null);
            p.setSex(null);
        } else if (args[0].equals("-i")) {
            id = Integer.parseInt(args[1]);
            System.out.println(allPeople.get(id));
        }
    }
}
