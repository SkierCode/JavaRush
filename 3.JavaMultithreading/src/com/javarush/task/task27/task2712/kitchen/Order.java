package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int count = 0;
        for (Dish dish : dishes) {
            count += dish.getDuration();
        }
        return count;
    }
    public boolean isEmpty() {
        return dishes.isEmpty();
    }


    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        } else return "Your order: " + dishes.toString()+ " of " + tablet;
    }
}
