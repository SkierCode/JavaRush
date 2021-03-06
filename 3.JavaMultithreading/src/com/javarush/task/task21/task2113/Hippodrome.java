package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        horses.forEach(Horse::move);
    }
    public void print(){
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) { System.out.println(); }
    }
    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            Thread.sleep(200);
            print();
        }
    }
    public Horse getWinner(){
        return horses.stream().
                max(Comparator.comparingDouble(Horse::getDistance)).
                get();
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }



    public static void main(String[] args) throws InterruptedException {
        List<Horse> myHorses = new ArrayList<>();
        myHorses.add(new Horse("Armas", 3, 0));
        myHorses.add(new Horse("Pegas", 3, 0));
        myHorses.add(new Horse("Glicinia", 3, 0));
        game = new Hippodrome(myHorses);
        game.run();
        game.printWinner();
    }
}
