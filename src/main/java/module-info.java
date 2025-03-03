module org.example.sudokuapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.apache.pdfbox;
    requires java.desktop;
    requires openhtmltopdf.pdfbox;
    requires tess4j;
    requires org.bytedeco.opencv;

    opens org.example.sudokuapp to javafx.fxml;
    exports org.example.sudokuapp;
    exports org.example.sudokuapp.ui;
    opens org.example.sudokuapp.ui to javafx.fxml;
    exports org.example.sudokuapp.logic;
    opens org.example.sudokuapp.logic to javafx.fxml;
    exports org.example.sudokuapp.main;
    opens org.example.sudokuapp.main to javafx.fxml;
}