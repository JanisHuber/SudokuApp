package org.example.sudokuapp.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.example.sudokuapp.logic.GeneratingSudoku;
import org.example.sudokuapp.logic.Sudoku;

import java.io.IOException;
import java.util.Optional;


public class GenerateSudoku_ViewController {
    @FXML
    TextField txtField_SudokuDifficulty;
    @FXML
    GridPane gridPane_Sudoku;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void view_BackHome() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/sudokuapp/fxml/HomeScreen_View.fxml"));
        root = fxmlLoader.load();
        HomeScreen_ViewController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sudoku App");
        stage.setHeight(700);
        stage.setWidth(800);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void view_ExportSudoku() {
        Sudoku exportSudoku = new Sudoku(getSudoku());

        //exportSudoku.saveAsPDF();
    }

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

    @FXML
    private char[][] getSudoku() {
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

    private Optional<Pair<String, String>> showDialog() {
        return Optional.empty();
    }
}
