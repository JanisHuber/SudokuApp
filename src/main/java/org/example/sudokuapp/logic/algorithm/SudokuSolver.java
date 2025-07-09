package org.example.sudokuapp.logic.algorithm;

import org.example.sudokuapp.logic.misc.Coordinates;
import org.example.sudokuapp.logic.misc.Sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolver {
    Random random = new Random();
    List<Coordinates> blockedCells = new ArrayList<>();
    Sudoku solvedSudoku = null;


    public Sudoku solve(Sudoku sudoku) {
        char[][] sudokuArray = sudoku.getCharArray();

        setBlockedCells(new Sudoku(sudokuArray));

        if (!backtracking(sudokuArray, 0, 0)) {
            return null;
        }

        return solvedSudoku;
    }

    public char[][] getNextStep(char[][] oldBoard) {
        Sudoku sudoku = new Sudoku(oldBoard);
        char[][] newBoard = solve(new Sudoku(sudoku.getCharArray())).getCharArray();

        AtomicBoolean hasNextStep = new AtomicBoolean(false);

        sudoku.forEachCell(cell -> {
            Coordinates coordinates = cell.getCoordinates();

            if (newBoard[coordinates.row()][coordinates.column()] == '\u0000') {
                if (!hasNextStep.get()) {
                    newBoard[coordinates.row()][coordinates.column()] = cell.getChar();
                    hasNextStep.set(true);
                } else {
                    newBoard[coordinates.row()][coordinates.column()] = '\u0000';
                }
            }
        });

        return newBoard;
    }


    private boolean backtracking(char[][] sudoku, int x, int y) {
        if (y == 9) {
            return true;
        }

        int nextX = (x + 1) % 9;
        int nextY = (nextX == 0) ? y + 1 : y;

        if (blockedCells.contains(new Coordinates(y, x))) {
            return backtracking(sudoku, nextX, nextY);
        }

        for (int num : getShuffledNumbers()) {
            if (isValid(sudoku, x, y, (char) (num + '0'))) {
                sudoku[y][x] = (char) (num + '0');
                if (backtracking(sudoku, nextX, nextY)) {
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
        sudoku.forEachCell(cell -> {
            if (cell.isFilled()) {
                blockedCells.add(cell.getCoordinates());
            }
        });
    }
}
