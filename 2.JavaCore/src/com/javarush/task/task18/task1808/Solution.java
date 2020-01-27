package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream1 = new FileInputStream(reader.readLine());
        FileOutputStream stream2 = new FileOutputStream(reader.readLine());
        FileOutputStream stream3 = new FileOutputStream(reader.readLine());
        int secondHalfStreamLong = stream1.available() / 2;
        int firstHalfStreamLong = stream1.available() - secondHalfStreamLong;
        if (stream1.available() > 0){
            byte[] buffer1 = new byte[firstHalfStreamLong];
            int count1 = stream1.read(buffer1);
            stream2.write(buffer1, 0, count1);

            byte[] buffer2 = new byte[secondHalfStreamLong];
            int count2 = stream1.read(buffer2);
            stream3.write(buffer2, 0, count2);
        }
        reader.close();
        stream1.close();
        stream2.close();
        stream3.close();
    }
}
