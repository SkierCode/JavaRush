package com.javarush.task.task38.task3810;

public @interface Revision {
    //напиши свой код
    String comment() default "";

    Date date();

    Author[] authors() default {};

    int revision();
}
