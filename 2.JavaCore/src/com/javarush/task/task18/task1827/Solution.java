package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fr = new BufferedReader(new FileReader(fileName));
            int id = 0, max = 0;
            StringBuilder stringBuilder = new StringBuilder();
            Solution sol = new Solution();
            String strId, productName, price, quantity;

            while (fr.ready()) {
                strId = fr.readLine();
                stringBuilder.append(strId).append("\n");
                id = sol.getId(strId);
                if (id > max) max = id;
            }
            fr.close();

            strId = Integer.toString(max +1 );
            strId = sol.getNeedString(strId, 8);
            productName = sol.getNeedString(sol.getProductName(args), 30);
            price = sol.getNeedString(args[args.length - 2], 8);
            quantity = sol.getNeedString(args[args.length - 1], 4);

            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
            fw.write(stringBuilder.toString());
            fw.write(strId + productName + price + quantity);

            fw.close();
        }
    }

    public String getProductName(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < args.length - 2; i++) {
            s.append(args[i]).append(" ");
        }
        s = new StringBuilder(s.toString().trim());
        return s.toString();
    }

    public int getId(String s) {
        return Integer.parseInt(s.substring(0, 8).trim());
    }

    public String getNeedString(String s, int count) {
        if (s.length() < count) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < count - s.length(); i++) {
                sb.append(" ");
            }
            s = sb.toString();
        } else s = s.substring(0, count);
        return s;
    }
}
