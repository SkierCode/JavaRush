package com.javarush.task.task14.task1421;

public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(instance == null) instance = new Singleton();
        return instance;
    }

}

