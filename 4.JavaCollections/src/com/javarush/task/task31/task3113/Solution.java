package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    private static long folderCount = 0;
    private static long fileCount = 0;
    private static long size = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Введите полный путь к папке");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final Solution solution = new Solution();

        Path path = Paths.get(reader.readLine());

        if (!Files.isDirectory(path)) {
            System.out.println(path.toString() + " - не папка");
            return;
        }

        Files.walkFileTree(path, solution);

        System.out.printf("Всего папок - %d%nВсего файлов - %d%nОбщий размер - %d",
                folderCount - 1, fileCount, size);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folderCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileCount++;
        size += Files.size(file);
        return FileVisitResult.CONTINUE;
    }
}
