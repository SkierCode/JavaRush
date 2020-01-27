package com.javarush.games.minesweeper;

public class GameObject {

    public int x, y, countMineNeighbors;
    public boolean isMine, isOpen, isFlag;

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
