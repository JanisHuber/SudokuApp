package org.example.sudokuapp;

import org.example.sudokuapp.main.Coordinates;
import org.example.sudokuapp.main.Sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuSolver {
    Random random = new Random();
    List<Coordinates> blockedCells = new ArrayList<>();
    Sudoku solvedSudoku = null;

    public Sudoku solve(Sudoku sudoku) {
        setBlockedCells(sudoku);

        if (!backtracking(sudoku.getSudoku(), 0, 0, 0)) {
            return null;
        }

        return solvedSudoku;
    }

    private boolean backtracking(char[][] sudoku, int x, int y, int path) {
        if (y == 9) {
            return true;
        }

        int nextX = (x + 1) % 9;
        int nextY = (nextX == 0) ? y + 1 : y;

        if (blockedCells.contains(new Coordinates(y, x))) {
            return backtracking(sudoku, nextX, nextY, path + 1);
        }

        for (int num : getShuffledNumbers()) {
            if (isValid(sudoku, x, y, (char) (num + '0'))) {
                sudoku[y][x] = (char) (num + '0');
                if (backtracking(sudoku, nextX, nextY, path + 1)) {
                    solvedSudoku = new Sudoku(sudoku);
                    return true;
                }
                sudoku[y][x] = '\u0000';
            }
        }
        return false;
    }

    private int[] getShuffledNumbers() {
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 9 - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    private boolean isValid(char[][] board, int x, int y, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == num || board[i][x] == num) {
                return false;
            }
        }

        int subGridRow = (y / 3) * 3;
        int subGridCol = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subGridRow + i][subGridCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private void setBlockedCells(Sudoku sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] != '\u0000') {
                    blockedCells.add(new Coordinates(i, j));
                }
            }
        }
    }
}
