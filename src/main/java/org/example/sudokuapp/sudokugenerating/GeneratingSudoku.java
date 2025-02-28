package org.example.sudokuapp.sudokugenerating;

import org.example.sudokuapp.SudokuSolver;
import org.example.sudokuapp.main.Sudoku;

public class GeneratingSudoku {

    public Sudoku generateSudoku(Integer difficulty) {
        char[][] result = new SudokuSolver().solve(new Sudoku(new char[9][9])).getSudoku();
        for (int i = 0; i < difficulty / 10; i++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            result[row][col] = 0;
        }
        return new Sudoku(result);

        /*while (true) {
            char[][] sudokuChar = new char[9][9];

            for (int i = 0; i < difficulty; i++) {
                int row = (int) (Math.random() * 9);
                int col = (int) (Math.random() * 9);
                int value = (int) (Math.random() * 9) + 1;

                if (sudokuChar[row][col] == 0) {
                    sudokuChar[row][col] = (char) (value + '0');
                }
            }

            if (new SudokuSolver().solve(new Sudoku(getCopy(sudokuChar))) != null) {
                return new Sudoku(sudokuChar);
            }
        }*/
    }


    private char[][] getCopy(char[][] original) {
        char[][] copy = new char[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                copy[r][c] = original[r][c];
            }
        }
        return copy;
    }
}
