package org.example.sudokuapp.logic.misc;

import java.util.Arrays;

public class Sudoku {
    private char[][] sudoku;

    public Sudoku(char[][] sudoku) {
        this.sudoku = sudoku;
    }

    public char[][] getCopy() { //todo
        char[][] copy = new char[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                copy[r][c] = sudoku[r][c];
            }
        }
        return copy;
    }

    public char[][] getSudoku() {
        return sudoku;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Sudoku)) {
            return false;
        }

        Sudoku sudoku = (Sudoku) obj;
        return Arrays.deepEquals(this.sudoku, sudoku.getSudoku());
    }

    public void saveAsPDF(String fullPath) {
        PDFConverter converter = new PDFConverter();
        converter.convertSudokuToPDF(fullPath, sudoku);
    }


    public int getFilledAmountOfCells() {
        int result = 0;

        for (char[] row : sudoku) {
            for (char c : row) {
                if (c != '\u0000') {
                    result++;
                }
            }
        }
        return result;
    }
}
