package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        for (s = reader.readLine(); true ; s = reader.readLine()) {
            FileInputStream stream = null;
            try{
                stream = new FileInputStream(s);
            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            }
            finally {
                try {
                    stream.close();
                }catch (NullPointerException e){}

            }
            stream.close();
        }
    }
}
