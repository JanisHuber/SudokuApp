package org.example.sudokuapp.main;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuTest {
    @Test
    void sudokuGetTileValuesTest() {
        char[][] sudokuChar = getSudoku();
        Sudoku sudoku = new Sudoku(sudokuChar);

        List<Integer> tileValues = sudoku.getTilesValue();

        for (Integer v : tileValues) {
            assertThat(v).isEqualTo(45);
        }
    }

    private char[][] getSudoku() {
        char[][] sudokuChar = new char[9][9];

        sudokuChar[0] = new char[]{'5', '3', '4', '6', '7', '8', '9', '1', '2'};
        sudokuChar[1] = new char[]{'6', '7', '2', '1', '9', '5', '3', '4', '8'};
        sudokuChar[2] = new char[]{'1', '9', '8', '3', '4', '2', '5', '6', '7'};
        sudokuChar[3] = new char[]{'8', '5', '9', '7', '6', '1', '4', '2', '3'};
        sudokuChar[4] = new char[]{'4', '2', '6', '8', '5', '3', '7', '9', '1'};
        sudokuChar[5] = new char[]{'7', '1', '3', '9', '2', '4', '8', '5', '6'};
        sudokuChar[6] = new char[]{'9', '6', '1', '5', '3', '7', '2', '8', '4'};
        sudokuChar[7] = new char[]{'2', '8', '7', '4', '1', '9', '6', '3', '5'};
        sudokuChar[8] = new char[]{'3', '4', '5', '2', '8', '6', '1', '7', '9'};

        return sudokuChar;
    }
}