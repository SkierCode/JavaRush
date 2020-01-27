package com.javarush.task.task25.task2502;

import java.lang.reflect.Array;
import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();
            int wheelcount = 0;
            String[] rounds = loadWheelNamesFromDB();
            for (int i = 0; i < rounds.length; i++) {
                wheels.add(Wheel.valueOf(rounds[i]));
                wheelcount++;
            }
            if (wheelcount !=4) throw new Exception();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
