package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String iFindIt = null;
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            st.nextToken("?");
            s = st.nextElement().toString();
        }
        st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            String r;
            r = st.nextToken("&");
            list.add(r);
        }

        for (int i = 0; i < list.size(); i++) {
            st = new StringTokenizer(list.get(i));
            if (list.get(i).contains("obj")){
                list.set(i, st.nextToken("="));
                iFindIt = st.nextElement().toString();
            }
            else list.set(i, st.nextToken("="));
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == (list.size() - 1))
                System.out.println(list.get(i));
            else System.out.print(list.get(i) + " ");
        }

        if(iFindIt != null && iFindIt.matches("-?\\d+(\\.\\d+)?"))
            alert(Double.parseDouble(iFindIt));
        else if (iFindIt != null) alert(iFindIt);

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
