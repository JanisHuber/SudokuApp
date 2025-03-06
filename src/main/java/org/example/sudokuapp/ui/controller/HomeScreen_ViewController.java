package org.example.sudokuapp.ui.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.example.sudokuapp.ui.Navigation;

import java.io.IOException;

public class HomeScreen_ViewController {
    @FXML
    private Stage stage;

    @FXML
    public void link_GenerateSudoku() throws IOException {
        Object controller = Navigation.navigateTo(stage, "/org/example/sudokuapp/fxml/GenerateSudoku_View.fxml", "Generate Sudoku", 800, 700);
        ((GenerateSudoku_ViewController) controller).setStage(stage);
    }

    public void link_SolveSudoku() throws IOException {
        Object controller = Navigation.navigateTo(stage, "/org/example/sudokuapp/fxml/SolveSudoku_View.fxml", "Solve Sudoku", 800, 700);
        ((SolveSudoku_ViewController) controller).setStage(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}