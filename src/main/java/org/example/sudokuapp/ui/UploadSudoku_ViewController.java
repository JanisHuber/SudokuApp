package org.example.sudokuapp.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UploadSudoku_ViewController {
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
}
