package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger priorityCount = new AtomicInteger(0);

    public MyThread() {
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

    private void init() {
        priorityCount.incrementAndGet();
        priorityCount.weakCompareAndSet(11, 1);
        int myPriority = priorityCount.get();
        if ((this.getThreadGroup() != null && this.getThreadGroup().getMaxPriority() < myPriority)) {
            setPriority(this.getThreadGroup().getMaxPriority());
        } else {
            setPriority(myPriority);
        }
    }
}
