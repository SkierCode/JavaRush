package com.javarush.task.task16.task1630;

import javax.smartcardio.ATR;
import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader reader;

    //add your code here - добавьте код тут

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        BufferedReader reader;
        int flag = 0;

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            StringBuilder sb = new StringBuilder();
            String str;
            if (flag == 0 )
                return "";
            try {
                reader = new BufferedReader(new FileReader(fullFileName));
                while ((str = reader.readLine()) != null) {
                    sb.append(str);
                    sb.append(" ");
                }
            } catch (FileNotFoundException e) {
                return "";
            } catch (IOException e) {
                return "";
            }

            return sb.toString();
        }

        @Override
        public void run() {
            flag = 1;
            getFileContent();
        }
    }
}
