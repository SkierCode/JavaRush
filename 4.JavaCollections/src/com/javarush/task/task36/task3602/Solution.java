package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
            if (Modifier.isPrivate(clazz.getModifiers())) {
                if (Modifier.isStatic(clazz.getModifiers())) {
                    if (List.class.isAssignableFrom(clazz)) {
                        try {
                            Constructor constructor = clazz.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                            e.printStackTrace();
                        } catch ( IndexOutOfBoundsException e){
                            return clazz;
                        }
                    }
                }
            }
        }
        return null;
    }
}
