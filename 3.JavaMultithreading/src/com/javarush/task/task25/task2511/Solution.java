package com.javarush.task.task25.task2511;


import java.lang.Thread.UncaughtExceptionHandler;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        //init handler here
        this.handler = (t, e) -> {
            System.out.println(e.getMessage().replaceAll(
                    t.getName(),
                    t.getName().replaceAll(".", "*")
                    )
            );

        };
    }

    public void run() {
        try {
            original.run();
            throw new Exception();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah ", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Solution(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(5 / 0);
            }
        }));
        thread.start();
    }
}
