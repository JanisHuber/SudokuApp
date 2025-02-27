package org.example.sudokuapp.sudokugenerating;

import org.example.sudokuapp.main.Sudoku;
import org.example.sudokuapp.main.SudokuTester;

import java.util.Arrays;

public class GeneratingSudoku {

    public Sudoku generateSudoku(Integer difficulty) {
        boolean isValid = false;
        Sudoku sudoku = null;

        while (!isValid) {
            char[][] sudokuChar = new char[9][9];

            for (int i = 0; i < difficulty; i++) {
                int row = (int) (Math.random() * 9);
                int col = (int) (Math.random() * 9);
                int value = (int) (Math.random() * 9) + 1;

                if (sudokuChar[row][col] == 0) {
                    sudokuChar[row][col] = (char) (value + '0');
                }
            }
            System.out.println(Arrays.deepToString(sudokuChar));

            if (SudokuTester.isSudokuValid(new Sudoku(sudokuChar))) {
                System.out.println("Sudoku generated");
                isValid = true;
                sudoku = new Sudoku(sudokuChar);
            }
        }

        return sudoku;
    }
}
