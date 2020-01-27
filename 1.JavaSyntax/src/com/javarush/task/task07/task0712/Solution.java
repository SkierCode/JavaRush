package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i, iMin, iMax, nMin=0, nMax=0;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i=0; i<10; i++)
            list.add(reader.readLine());
        iMax=iMin=list.get(0).length();
        for (i=1; i<list.size();i++){
            if (list.get(i).length() < iMin) {
                iMin = list.get(i).length();
                nMin = i;
            }
            else if(list.get(i).length()>iMax) {
                iMax = list.get(i).length();
                nMax = i;
            }
        }
        if (nMin < nMax)
            System.out.println(list.get(nMin));
        else if (nMin > nMax)
            System.out.println(list.get(nMax));
    }
}
