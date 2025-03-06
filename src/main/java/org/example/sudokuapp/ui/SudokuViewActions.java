package org.example.sudokuapp.ui;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuViewActions {
    GridPane gridPane_Sudoku;

    public SudokuViewActions(GridPane gridPane) {
        this.gridPane_Sudoku = gridPane;
    }

    public void clearSudoku() {
        for (Node node : gridPane_Sudoku.getChildren()) {
            if (node instanceof TextField) {
                TextField tf = (TextField) node;
                tf.clear();
            }
        }
    }

    public void updateSudoku(char[][] sudoku) {
        for (Node node : gridPane_Sudoku.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            int row = (rowIndex == null) ? 0 : rowIndex;
            Integer colIndex = GridPane.getColumnIndex(node);
            int col = (colIndex == null) ? 0 : colIndex;

            if (node instanceof TextField) {
                TextField tf = (TextField) node;
                tf.setText(String.valueOf(sudoku[row][col]));
            }
        }
    }

    public char[][] getSudoku() {
        char[][] sudoku = new char[9][9];
        for (Node node : gridPane_Sudoku.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            int row = (rowIndex == null) ? 0 : rowIndex;
            Integer colIndex = GridPane.getColumnIndex(node);
            int col = (colIndex == null) ? 0 : colIndex;

            if (node instanceof TextField) {
                TextField tf = (TextField) node;
                if (tf.getText().isEmpty()) {
                    sudoku[row][col] = 0;
                } else {
                    sudoku[row][col] = tf.getText().charAt(0);
                }
            }
        }
        return sudoku;
    }
}
