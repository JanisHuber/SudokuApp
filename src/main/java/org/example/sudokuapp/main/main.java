package org.example.sudokuapp.main;

import org.example.sudokuapp.sudokugenerating.GeneratingSudoku;

public class main {
    public static void main(String[] args) {
        GeneratingSudoku sudoku = new GeneratingSudoku();
        char[][] sudokuChar = sudoku.generateSudoku(100);

        for (char[] row : sudokuChar) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
