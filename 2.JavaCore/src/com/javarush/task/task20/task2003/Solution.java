package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        load(new FileInputStream(reader.readLine()));
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter fw = new PrintWriter(outputStream);
        Properties prop = new Properties();
        for (Map.Entry<String, String> p : properties.entrySet()) {
            prop.put(p.getKey(), p.getValue());
        }
        prop.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        for (String x : prop.stringPropertyNames())
            properties.put(x, prop.getProperty(x));

        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
