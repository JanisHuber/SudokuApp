package org.example.sudokuapp.main;

import org.example.sudokuapp.SudokuSolver;
import org.example.sudokuapp.sudokugenerating.GeneratingSudoku;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        char[][] char1 = new char[][]{
                {0, 9, 2, 6, 0, 7, 4, 0, 5},
                {5, 0, 8, 0, 0, 4, 2, 0, 0},
                {0, 3, 0, 9, 0, 5, 0, 7, 8},
                {0, 1, 9, 0, 4, 3, 5, 0, 0},
                {7, 2, 0, 5, 6, 0, 0, 1, 3},
                {0, 0, 3, 2, 1, 0, 9, 4, 0},
                {0, 8, 1, 0, 0, 6, 7, 0, 4},
                {9, 0, 7, 4, 5, 0, 0, 8, 2},
                {3, 0, 5, 8, 7, 2, 0, 9, 1}
        };

        char[][] char2 = new char[][]{
                {0, '5', 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, '3', 0, 0, 0, '9', 0},
                {'2', '1', 0, 0, 0, 0, 0, 0, '8'},
                {'6', '2', 0, '7', 0, 0, '1', 0, 0},
                {0, 0, '5', 0, '2', 0, 0, 0, 0},
                {0, 0, '3', 0, 0, 0, 0, 0, '6'},
                {0, 0, 0, 0, 0, '4', '7', 0, 0},
                {'8', '9', 0, 0, '3', 0, 0, 0, '1'},
                {0, 0, '6', 0, 0, 0, 0, 0, 0}
        };

        char[][] char3 = {
                {'5', '3', 0, 0, '7', 0, 0, 0, 0},
                {'6', 0, 0, '1', '9', '5', 0, 0, 0},
                {0, '9', '8', 0, 0, 0, 0, '6', 0},
                {'8', 0, 0, 0, '6', 0, 0, 0, '3'},
                {'4', 0, 0, '8', 0, '3', 0, 0, '1'},
                {'7', 0, 0, 0, '2', 0, 0, 0, '6'},
                {0, '6', 0, 0, 0, 0, '2', '8', 0},
                {0, 0, 0, '4', '1', '9', 0, 0, '5'},
                {0, 0, 0, 0, '8', 0, 0, '7', '9'}
        };

        /*Sudoku sudoku = new Sudoku(char3);
        SudokuSolver solver = new SudokuSolver();

        System.out.println(Arrays.deepToString(solver.solve(sudoku).getSudoku()));*/

        GeneratingSudoku s = new GeneratingSudoku();
        Sudoku result = s.generateSudoku(100);

        System.out.println("Generated Sudoku: " + Arrays.deepToString(result.getSudoku()));
    }
}