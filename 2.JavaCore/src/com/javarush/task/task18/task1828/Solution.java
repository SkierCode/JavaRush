package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0 && args[0].equals("-u")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fr = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String s, id, productName, price, quantity;
            Solution sol = new Solution();
            while (fr.ready()) {
                s = fr.readLine();
                if (Integer.parseInt(args[1]) == sol.getId(s)) {
                    id = sol.getNeedString(args[1], 8);
                    productName = sol.getNeedString(sol.getProductName(args), 30);
                    price = sol.getNeedString(args[args.length - 2], 8);
                    quantity = sol.getNeedString(args[args.length - 1], 4);
                    stringBuilder.append(id)
                            .append(productName)
                            .append(price)
                            .append(quantity)
                            .append("\n");
                } else stringBuilder.append(s).append("\n");
            }
            fr.close();

            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
            fw.write(stringBuilder.toString());

            fw.close();
        }

        if (args.length != 0 && args[0].equals("-d")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            Solution sol = new Solution();
            reader.close();
            BufferedReader fr = new BufferedReader(new FileReader(fileName));
            while (fr.ready()) {
                s = fr.readLine();
                if (Integer.parseInt(args[1]) == sol.getId(s)) continue;
                stringBuilder.append(s).append("\n");
            }
            fr.close();

            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
            fw.write(stringBuilder.toString());
            fw.close();
        }
    }

    public String getProductName(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
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
