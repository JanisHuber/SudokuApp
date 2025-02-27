module org.example.sudokuapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.sudokuapp to javafx.fxml;
    exports org.example.sudokuapp;
    exports org.example.sudokuapp.ui;
    opens org.example.sudokuapp.ui to javafx.fxml;
}