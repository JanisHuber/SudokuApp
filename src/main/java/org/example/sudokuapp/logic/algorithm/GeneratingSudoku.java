package org.example.sudokuapp.logic.algorithm;

import org.example.sudokuapp.logic.misc.Sudoku;

public class GeneratingSudoku {

    public Sudoku generateSudoku(Integer difficulty) {
        char[][] result = new SudokuSolver().solve(new Sudoku(new char[9][9])).getSudoku();

        for (int i = 0; i < difficulty / 10; i++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            result[row][col] = 0;
        }
        return new Sudoku(result);
    }
}
