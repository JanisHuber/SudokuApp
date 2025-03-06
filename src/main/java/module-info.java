module org.example.sudokuapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.apache.pdfbox;
    requires java.desktop;
    requires openhtmltopdf.pdfbox;
    requires tess4j;
    requires org.bytedeco.opencv;


    exports org.example.sudokuapp.ui;
    opens org.example.sudokuapp.ui to javafx.fxml;
    exports org.example.sudokuapp.main;
    opens org.example.sudokuapp.main to javafx.fxml;
    exports org.example.sudokuapp.ui.controller;
    opens org.example.sudokuapp.ui.controller to javafx.fxml;
    exports org.example.sudokuapp.logic.misc;
    opens org.example.sudokuapp.logic.misc to javafx.fxml;
    exports org.example.sudokuapp.logic.ocr;
    opens org.example.sudokuapp.logic.ocr to javafx.fxml;
    exports org.example.sudokuapp.logic.algorithm;
    opens org.example.sudokuapp.logic.algorithm to javafx.fxml;
}