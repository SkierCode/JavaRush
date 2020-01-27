package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        ArrayList<Integer>list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())))) {
        for(String line = br.readLine(); line != null; line = br.readLine()){
            StringTokenizer st = new StringTokenizer(line," ");
            while (st.hasMoreTokens()){
                String token = st.nextToken();
                if ((Integer.parseInt(token)%2) == 0) list.add(Integer.parseInt(token));
            }
        }
        } catch (FileNotFoundException e) {} catch (IOException e) {}
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
