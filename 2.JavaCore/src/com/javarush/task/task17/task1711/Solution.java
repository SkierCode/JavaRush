package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int id;
        String name, sex, date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    id = allPeople.size() - 1;
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        sex = args[i + 1];
                        date = args[i + 2];
                        if (sex.equals("м"))
                            allPeople.add(Person.createMale(name, sdf.parse(date)));
                        else if (sex.equals("ж"))
                            allPeople.add(Person.createFemale(name, sdf.parse(date)));
                    }
                }
                for (int i = id + 1; i < allPeople.size(); i++)
                    System.out.println(i);
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        id = Integer.parseInt(args[i]);
                        name = args[i + 1];
                        sex = args[i + 2];
                        date = args[i + 3];
                        for (int j = 0; j < allPeople.size(); j++)
                        {
                            if (id == j){
                                allPeople.get(j).setName(name);
                                allPeople.get(j).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                                allPeople.get(j).setBirthDate(sdf.parse(date));
                            }
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    Person p;
                    for (int i = 1; i < args.length; i++) {
                        p = allPeople.get(Integer.parseInt(args[i]));
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])));
                    }
                }
                break;
        }
    }
}
