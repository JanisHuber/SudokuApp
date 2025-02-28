package org.example.sudokuapp.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {
    private char[][] sudoku;
    //private List<char[][]> tiles;

    public Sudoku(char[][] sudoku) {
        this.sudoku = sudoku;
        //this.tiles = getTiles(sudoku);
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


    /*public List<Integer> getTilesValue() {
        List<Integer> tileValues = new ArrayList<>();

        for (char[][] tile : tiles) {
            Integer tileValue = 0;
            for (char[] row : tile) {
                for (char c : row) {
                    tileValue += Character.getNumericValue(c);
                }
            }
            tileValues.add(tileValue);
        }
        return tileValues;
    }

    private List<char[][]> getTiles(char[][] sudoku) {
        List<char[][]> tiles = new ArrayList<>();

        for (int blockRow = 0; blockRow < 3; blockRow += 3) {
            for (int blockCol = 0; blockCol < 3; blockCol += 3) {
                char[][] tile = new char[3][3];

                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        tile[row][col] = sudoku[blockRow + row][blockCol + col];
                    }
                }
                tiles.add(tile);
            }
        }
        return tiles;
    }*/
}
