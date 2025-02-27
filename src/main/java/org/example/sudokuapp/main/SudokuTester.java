package org.example.sudokuapp.main;

public class SudokuTester {
    public static boolean isSolvedSudokuValid(Sudoku sudoku) {
        for (char[] row : sudoku.getSudoku()) {
            int temp = 0;
            for (char c : row) {
                temp += Character.getNumericValue(c);
            }
            if (temp != 45) {
                return false;
            }
        }

        for (Integer value : sudoku.getTilesValue()) {
            if (value != 45) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSudokuValid(Sudoku sudoku) {
        char[][] sudokuChar = sudoku.getSudoku();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = sudokuChar[i][j];
                if (current == 0) {
                    continue;
                }
                boolean hasDuplicate = getRowDuplicate(sudokuChar, i, j, current) || getColumnDuplicate(sudokuChar, i, j, current) || getBoxDuplicate(sudokuChar, i, j, current);
                if (hasDuplicate) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean getRowDuplicate(char[][] sudokuChar, int row, int col, char current) {
        for (int i = 0; i < 9; i++) {
            if (i != col && sudokuChar[row][i] == current) {
                return true;
            }
        }
        return false;
    }

    private static boolean getColumnDuplicate(char[][] sudokuChar, int row, int col, char current) {
        for (int i = 0; i < 9; i++) {
            if (i != row && sudokuChar[i][col] == current) {
                return true;
            }
        }
        return false;
    }

    private static boolean getBoxDuplicate(char[][] sudokuChar, int row, int col, char current) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i != row && j != col && sudokuChar[i][j] == current) {
                    return true;
                }
            }
        }
        return false;
    }
}
