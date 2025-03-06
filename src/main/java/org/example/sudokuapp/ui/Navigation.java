package org.example.sudokuapp.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public static Object navigateTo(Stage stage, String fxmlPath, String title, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource(fxmlPath));
        Parent root = fxmlLoader.load();

        Object controller = fxmlLoader.getController();

        stage = (Stage) stage.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.show();

        return controller;
    }
}
