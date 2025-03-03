package org.example.sudokuapp.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.sudokuapp.ui.HomeScreen_ViewController;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/org/example/sudokuapp/fxml/HomeScreen_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

        HomeScreen_ViewController controller =fxmlLoader.getController();
        controller.setStage(stage);

        stage.setTitle("Sudoku-App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}