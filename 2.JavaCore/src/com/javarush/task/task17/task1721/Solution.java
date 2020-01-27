package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/* 
Транзакционность
*/

public class Solution {
        static String s1, s2;
        boolean allMatch;
        static BufferedReader reader1, reader2;
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())));
        reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())));

        while ((s1 = reader1.readLine()) != null) allLines.add(s1);
        while ((s2 = reader2.readLine()) != null) forRemoveLines.add(s2);
        reader1.close();
        reader2.close();

        try {
            new Solution().joinData();
        }catch (CorruptedDataException e){
            System.out.println("не совпали");
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
