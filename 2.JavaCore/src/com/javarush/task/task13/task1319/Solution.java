package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); // поток чтения с консоли
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  // соединяем InputStreamReader с BufferedReader

            File file = new File(bufferedReader.readLine());

            FileWriter fileReader = new FileWriter(file); // поток который подключается к текстовому файлу
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // соединяем FileWriter с BufferedWitter

            String line;
            do {
                line = bufferedReader.readLine();
                bufferedWriter.newLine();
                bufferedWriter.write(line);
            }  while (!(line.equals("exit")));

            bufferedReader.close(); // закрываем поток
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
