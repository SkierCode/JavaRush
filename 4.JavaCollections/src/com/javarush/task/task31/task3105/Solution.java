package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String archiveName = args[1];
        File file = new File(fileName);
        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archiveName))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[8 * 1024];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0,len);
                }
                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archiveName))) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                if (pair.getKey().contains(file.getName())) continue;
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
            Files.copy(file.toPath(), zipOutputStream);
        }
    }
}
