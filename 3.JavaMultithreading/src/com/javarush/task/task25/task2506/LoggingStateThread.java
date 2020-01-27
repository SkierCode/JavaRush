package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        Thread.State state = null;
        while (!(target.getState() == State.TERMINATED)) {
            if (state != target.getState()) {
                state = target.getState();
                System.out.println(state);
            }
        }
        System.out.println(State.TERMINATED);
    }
}
