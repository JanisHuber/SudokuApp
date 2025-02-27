package org.example.sudokuapp.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen_ViewController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void link_GenerateSudoku() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/example/sudokuapp/fxml/GenerateSudoku_View.fxml"));
        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Generate Sudoku");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
    }

    public void link_SolveSudoku() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/example/sudokuapp/fxml/GenerateSudoku_View.fxml"));
        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Solve Sudoku");
        stage.show();
    }

    public void link_UploadSudoku() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/org/example/sudokuapp/fxml/GenerateSudoku_View.fxml"));
        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Upload Sudoku");
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}