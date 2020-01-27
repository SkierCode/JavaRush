package com.javarush.task.task38.task3804;

import com.fasterxml.jackson.databind.util.EnumValues;

import java.util.EnumSet;

public class ExceptionFactory {

    public static Throwable getException(Enum e) {
        if (e != null) {
            String message = e.toString().charAt(0) +
                    e.toString().substring(1).toLowerCase().replaceAll("_", " ");
            if (e instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            } else if (e instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            } else if (e instanceof UserExceptionMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
