package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        writeMessage("Выберите блюда из представленных ниже:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Для завершения заказа наберите 'exit'");
        String s;
        while (!(s = readString()).equals("exit")) {
            if (Dish.allDishesToString().contains(s)) {
                order.add(Dish.valueOf(s));
                writeMessage("Блюдо успешно выбрано. Выберите следующее.");
            }else writeMessage("Такого блюда нет. Попробуйте еще разю");
        }
        return order;
    }

}
