package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private int countMinesOnField;
    private int countFlags, score;
    private int countClosedTiles = SIDE * SIDE;
    private boolean isGameStopped;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private void createGame() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                boolean mine = getRandomNumber(10) == 0;
                if (mine) countMinesOnField++;
                gameField[i][j] = new GameObject(j, i, mine);
                setCellColor(j, i, Color.ORANGE);
                setCellValue(j, i, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j].countMineNeighbors = getNeighbors(gameField[i][j]);
            }
        }
    }

    private int getNeighbors(GameObject gameObject) {
        int count = 0;
        int x = gameObject.x;
        int y = gameObject.y;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (checkNeighbors(x, y, i, j)
                        && gameField[y + i][x + j].isMine && !gameObject.isMine) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkNeighbors(int x, int y, int i, int j) {
        if (i == 0 && j == 0) return false;
        if (i == -1 && y == 0) return false;
        if (j == -1 && x == 0) return false;
        if (i == 1 && y == gameField.length - 1) return false;
        if (j == 1 && x == gameField.length - 1) return false;
        return true;
    }

    private void openTile(int x, int y) {
        if (isGameStopped || gameField[y][x].isOpen || gameField[y][x].isFlag) return;
        gameField[y][x].setOpen(true);
        if (!gameField[y][x].isMine) {
            score += 5;
            setScore(score);
        }
        countClosedTiles--;
        if (!gameField[y][x].isMine && gameField[y][x].countMineNeighbors > 0) {
            setCellColor(x, y, Color.GREEN);
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
        } else if (!gameField[y][x].isMine && gameField[y][x].countMineNeighbors == 0) {
            setCellValue(x, y, "");
            setCellColor(x, y, Color.GREEN);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (checkNeighbors(x, y, i, j)
                            && !gameField[y + i][x + j].isOpen
                            && !gameField[y + i][x + j].isMine) {
                        openTile(x + j, y + i);
                    }
                }
            }
        } else {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        }
        if (countClosedTiles == countMinesOnField && !gameField[y][x].isMine) win();
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;
        GameObject go = gameField[y][x];
        if (!(countFlags == 0) && !go.isOpen && !go.isFlag) {
            go.isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else if (go.isFlag) {
            go.isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles= SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "YOU LOOSE!!!", Color.RED, 75);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "YOU WIN!!!", Color.AQUA, 75);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
            return;
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        restart();
    }
}
