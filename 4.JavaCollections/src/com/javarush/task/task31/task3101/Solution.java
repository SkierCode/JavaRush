package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        ArrayList<File> smallFiles = new ArrayList<>();


        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath,
                    new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt"));
        }

        resultFileAbsolutePath = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        smallFiles = getFiles(path, smallFiles);

        Collections.sort(smallFiles);

        BufferedInputStream fis;
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(resultFileAbsolutePath));
        StringBuilder sb = new StringBuilder();
        for (File file : smallFiles) {
            fis = new BufferedInputStream(new FileInputStream(file));
            int c;
            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }
            sb.append("\n");
            fis.close();
        }
        byte[] bytes = sb.toString().getBytes();
        fos.write(bytes);
        fos.close();
    }

    public static ArrayList<File> getFiles(File path, ArrayList<File> list) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                getFiles(file, list);
            }
            else if (file.length() <= 50 ) list.add(file);
        }
        return list;
    }
}
