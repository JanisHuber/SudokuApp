package org.example.sudokuapp.ui;

import javafx.scene.control.ButtonType;

public class Dialog {
    public static void showDialog(String title, String content) {
        javafx.scene.control.Dialog<String> dialog = new javafx.scene.control.Dialog<>();
        dialog.setTitle(title);
        dialog.setContentText(content);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }
}
