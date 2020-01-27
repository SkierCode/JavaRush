package com.javarush.task.task20.task2027;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Кроссворд
*/
public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        final List<Word> list = detectAllWords(crossword, "home", "same", "grov");
        list.forEach(System.out::println);

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    private static void findFirstSymbol(int[][] crossword, String word, Queue<Word> list) {
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if ((char) crossword[i][j] == word.charAt(0)) {
                    final Word w = new Word(word);
                    w.setStartPoint(j, i);
                    list.add(w);
                }
            }
        }
    }

    private static boolean checkBoarders(int[][] crossword, int x, int y) {
        return x >= 0 && x < crossword[0].length && y >= 0 && y < crossword.length;
    }

    private static void findDirection(int[][] crossword, Word word, Queue<Word> words) {
        int x = word.startX;
        int y = word.startY;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (checkBoarders(crossword, x + j, y + i) && (char) crossword[y + i][x + j] == word.text.charAt(1)) {
                    final Word w = new Word(word.text);
                    w.setStartPoint(word.startX, word.startY);
                    w.setEndPoint(x + j, y + i);
                    words.add(w);
                }
            }
        }
    }

    private static Word findWord(int[][] crossword, Word word) {
        boolean flag = false;
        int iterX, iterY;
        for (int i = 0; i < word.text.length() - 1; i++) {
            flag = true;
            iterX = 0;
            iterY = 0;
            if (word.endX - word.startX != 0) {
                iterX = word.endX > word.startX ? i : -i;
            }
            if (word.endY - word.startY != 0) {
                iterY = word.endY > word.startY ? i : -i;
            }
            if (!checkBoarders(crossword, word.endX + iterX, 0) ||
                    !checkBoarders(crossword, 0, word.endY + iterY)) {
                flag = false;
            }
            if (!flag || (char) crossword[word.endY + iterY][word.endX + iterX] != word.text.charAt(i + 1)) {
                flag = false;
                break;
            }
            if (i == word.text.length() - 2) {
                word.setEndPoint(iterX + word.startX + (word.endX - word.startX), iterY + word.startY + (word.endY - word.startY));
            }
        }
        return flag ? word : null;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Queue<Word> wordQueue = new ArrayDeque<>();

        for (String w : words) {
            findFirstSymbol(crossword, w, wordQueue);
        }

        for (int i = 0; i < wordQueue.size(); i++) {
            findDirection(crossword, wordQueue.poll(), wordQueue);
        }

        return wordQueue.stream()
                .map(entry -> findWord(crossword, entry))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
