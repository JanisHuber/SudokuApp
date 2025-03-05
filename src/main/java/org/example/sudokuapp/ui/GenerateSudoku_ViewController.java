package org.example.sudokuapp.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.sudokuapp.logic.GeneratingSudoku;
import org.example.sudokuapp.logic.Sudoku;

import java.util.List;

public class GenerateSudoku_ViewController {
    @FXML
    TextField txtField_SudokuDifficulty;
    @FXML
    GridPane gridPane_Sudoku;



    @FXML
    public void view_GenerateSudoku() {
        GeneratingSudoku generatingSudoku = new GeneratingSudoku();

        Sudoku generatedSudoku = generatingSudoku.generateSudoku(Integer.parseInt(txtField_SudokuDifficulty.getText()));

        updateSudoku(generatedSudoku.getSudoku());
    }

    @FXML
    private void updateSudoku(char[][] sudoku) {
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

}
