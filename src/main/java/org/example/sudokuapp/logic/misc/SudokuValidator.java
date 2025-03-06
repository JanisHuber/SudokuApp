package org.example.sudokuapp.logic.misc;

public class SudokuValidator {

    public static boolean validate(char[][] board) {
        return areRowsValid(board) && areColumnsValid(board) && areSubgridsValid(board);
    }

    private static boolean areRowsValid(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isUnitValid(board[row])) {
                return false;
            }
        }
        return true;
    }

    private static boolean areColumnsValid(char[][] board) {
        for (int col = 0; col < 9; col++) {
            char[] column = new char[9];
            for (int row = 0; row < 9; row++) {
                column[row] = board[row][col];
            }
            if (!isUnitValid(column)) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSubgridsValid(char[][] board) {
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                char[] subgrid = new char[9];
                int index = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        subgrid[index++] = board[boxRow * 3 + i][boxCol * 3 + j];
                    }
                }
                if (!isUnitValid(subgrid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isUnitValid(char[] unit) {
        boolean[] seen = new boolean[9];
        for (char num : unit) {
            if (num != '\u0000') {
                int digit = num - '1';
                if (digit < 0 || digit > 8 || seen[digit]) {
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }
}
