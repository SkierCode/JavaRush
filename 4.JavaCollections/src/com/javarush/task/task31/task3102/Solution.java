package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        ArrayList<String> result = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        queue.offer(file);
        while (queue.peek() != null) {
            file = queue.poll();
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    queue.offer(f);
                }
                continue;
            }
            result.add(file.getAbsolutePath());
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("C:\\123");
        list.forEach(System.out::println);
    }
}
