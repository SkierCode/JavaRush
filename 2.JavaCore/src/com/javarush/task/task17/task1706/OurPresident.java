package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    private static final Object o = new Object();

    static {
        synchronized (o){
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {return president;}
}
