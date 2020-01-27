package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;
    private static final Object o = new Object();

    public static IMF getFund() {
        //add your code here - добавь код тут
        synchronized (o){
            if (imf == null)
                imf = new IMF();
        }
        return imf;
    }

    private IMF() {
    }
}
