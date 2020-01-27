package com.javarush.task.task27.task2712.kitchen;

import java.util.EnumSet;
import java.util.Set;

public enum  Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        Set<Dish> dishes = EnumSet.allOf(Dish.class);
        StringBuilder sb = new StringBuilder();
        for (Dish dish : dishes) {
            sb.append(dish).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
