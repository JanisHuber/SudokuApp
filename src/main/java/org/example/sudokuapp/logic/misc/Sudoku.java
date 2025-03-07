package org.example.sudokuapp.logic.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Sudoku {
    private List<Cell> cells = new ArrayList<>();

    public Sudoku(char[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                cells.add(new Cell(parseCharacter(sudoku[i][j]), new Coordinates(i, j)));
            }
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public char[][] getCharArray() {
        char[][] result = new char[9][9];

        forEachCell(cell -> {
            Coordinates coordinates = cell.getCoordinates();
            result[coordinates.row()][coordinates.column()] = cell.getChar();
        });

        return result;
    }

    public void saveAsPDF(String fullPath) {
        PDFConverter converter = new PDFConverter();
        converter.convertSudokuToPDF(fullPath, getCharArray());
    }

    public int getFilledAmountOfCells() {
        AtomicInteger result = new AtomicInteger(0);

        forEachCell(cell -> {
            if (cell.isFilled()) {
                result.getAndIncrement();
            }
        });

        return result.get();
    }

    public void forEachCell(CellAction action) {
        for (Cell cell : cells) {
            action.execute(cell);
        }
    }

    private Character parseCharacter(char c) {
        if (c == 0 || c == ' ' || c == '\u0000') {
            return '\u0000';
        }
        return c;
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

        return Arrays.deepEquals(getCharArray(), sudoku.getCharArray());
    }

    public interface CellAction {
        void execute(Cell cell);
    }
}
