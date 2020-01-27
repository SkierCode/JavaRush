package com.javarush.task.task37.task3711;

public class Computer {
    CPU cpu;
    HardDrive hardDrive;
    Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.hardDrive = new HardDrive();
        this.memory = new Memory();
    }

    public void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
