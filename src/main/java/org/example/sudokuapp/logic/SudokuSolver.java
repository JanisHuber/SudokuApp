package org.example.sudokuapp.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolver {
    Random random = new Random();
    List<Coordinates> blockedCells = new ArrayList<>();
    Sudoku solvedSudoku = null;

    public Sudoku solve(Sudoku sudoku) {
        char[][] sudokuArray = parseSudokuToArray(sudoku);

        setBlockedCells(new Sudoku(sudokuArray));

        if (!backtracking(sudokuArray, 0, 0, 0)) {
            return null;
        }

        return solvedSudoku;
    }

    public char[][] getNextStep(char[][] oldBoard) {
        char[][] newBoard = solve(new Sudoku(Sudoku.getCopy(oldBoard))).getSudoku();
        int temp = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (oldBoard[i][j] != '\u0000') {
                    newBoard[i][j] = oldBoard[i][j];
                } else {
                    if (temp > 0) {
                        newBoard[i][j] = '\u0000';
                    }
                    temp++;
                }
            }
        }
        return newBoard;
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

    private List<Integer> getShuffledNumbers() {
        List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers, random);
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

    private char[][] parseSudokuToArray(Sudoku sudoku) {
        char[][] result = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] == '\u0000' || (sudoku.getSudoku()[i][j] < '1' || sudoku.getSudoku()[i][j] > '9')) {
                    result[i][j] = '\u0000';
                } else {
                    result[i][j] = sudoku.getSudoku()[i][j];
                }
            }
        }
        return result;
    }
}
