package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File prop = new File(fileName);
        Properties properties = new Properties();
        try {
            if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("xml")) {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                properties.loadFromXML(fileInputStream);
            } else {
                FileReader reader = new FileReader(prop);
                properties.load(reader);
            }
            return properties;
        } catch (IOException e) {
            return new Properties();
        }
    }
}
