package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());

        if (inputStream1.available() > 0){
            byte[] buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            outputStream.write(buffer, 0, count);

        }
        inputStream1.close();
        if (inputStream2.available() > 0){
            byte[] buffer = new byte[inputStream2.available()];
            int count = inputStream2.read(buffer);
            outputStream.write(buffer, 0, count);

        }
        inputStream2.close();
        outputStream.close();

    }
}
