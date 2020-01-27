package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    public Model() {
        this.resetGameTiles();
        this.score = 0;
        this.maxTile = 0;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTile = getEmptyTiles();

        if (!emptyTile.isEmpty()) {
            int rndEmptyTile = (int) (Math.random() * emptyTile.size());
            Tile tile = emptyTile.get(rndEmptyTile);
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean flg = false;
        int j = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value != 0) {
                if (tiles[j].value != tiles[i].value) flg = true;
                tiles[j++].value = tiles[i].value;
            }
        }
        while (j < tiles.length) {
            tiles[j++].value = 0;
        }
        return flg;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tmpTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tmpTile = new Tile();
                Tile tile = tiles[i][j];
                tmpTiles[i][j] = tmpTile;
                tmpTile.value = tile.value;
            }
        }
        previousStates.push(tmpTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean flg = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0 && tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2;
                tiles[i + 1].value = 0;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                score += tiles[i].value;
                flg = true;
            }
        }
        compressTiles(tiles);
        return flg;
    }

    private void rotateClockwise() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 1; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j - 1].value == gameTiles[i][j].value
                        || gameTiles[j - 1][i].value == gameTiles[j][i].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }

    public boolean hasBoardChanged() {
        int prev = 0;
        int curr = 0;
        if (!previousStates.isEmpty()) {
            Tile[][] prevTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    prev += prevTiles[i][j].value;
                    curr += gameTiles[i][j].value;
                }
            }
        }
        return prev != curr;
    }

    void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean flg = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                flg = true;
            }
        }
        if (flg) addTile();
        isSaveNeeded = true;
    }

    void right() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    void up() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    void down() {
        saveState(gameTiles);
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

}
