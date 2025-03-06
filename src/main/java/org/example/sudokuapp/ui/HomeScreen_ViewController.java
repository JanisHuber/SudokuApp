package org.example.sudokuapp.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.sudokuapp.logic.GeneratingSudoku;

import java.io.IOException;

public class HomeScreen_ViewController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void link_GenerateSudoku() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/sudokuapp/fxml/GenerateSudoku_View.fxml"));
        root = fxmlLoader.load();
        GenerateSudoku_ViewController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Generate Sudoku");
        stage.setHeight(700);
        stage.setWidth(800);
        stage.show();
    }

    public void link_SolveSudoku() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/sudokuapp/fxml/SolveSudoku_View.fxml"));
        root = fxmlLoader.load();
        SolveSudoku_ViewController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Solve Sudoku");
        stage.setHeight(700);
        stage.setWidth(800);
        stage.show();
    }

    public void link_UploadSudoku() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/sudokuapp/fxml/UploadSudoku_View.fxml"));
        root = fxmlLoader.load();
        UploadSudoku_ViewController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage = (Stage) stage.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Upload Sudoku");
        stage.setHeight(700);
        stage.setWidth(800);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}