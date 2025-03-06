package org.example.sudokuapp.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.sudokuapp.logic.algorithm.SudokuSolver;
import org.example.sudokuapp.logic.misc.Sudoku;
import org.example.sudokuapp.logic.ocr.SudokuSegmentationOCR;
import org.example.sudokuapp.ui.Navigation;
import org.example.sudokuapp.ui.SudokuViewActions;

import java.io.File;
import java.io.IOException;

public class SolveSudoku_ViewController {
    @FXML
    GridPane gridPane_Sudoku;
    SudokuSolver solver;
    SudokuViewActions sudokuViewActions;
    private Stage stage;


    @FXML
    public void initialize() {
        this.sudokuViewActions = new SudokuViewActions(gridPane_Sudoku);
        this.solver = new SudokuSolver();
    }

    @FXML
    public void view_SolveSudoku() {
        Sudoku inputSudoku = new Sudoku(sudokuViewActions.getSudoku());
        Sudoku solvedSudoku = solver.solve(inputSudoku);

        updateSudoku(solvedSudoku.getSudoku());
    }

    @FXML
    public void view_ClearSudoku() {
        sudokuViewActions.clearSudoku();
    }

    @FXML
    public void view_GetTipp() {
        Sudoku inputSudoku = new Sudoku(sudokuViewActions.getSudoku());
        char[][] outputSudoku = solver.getNextStep(inputSudoku.getSudoku());

        updateSudoku(outputSudoku);
    }

    @FXML
    public void view_ExportSudoku() {
        Sudoku exportSudoku = new Sudoku(sudokuViewActions.getSudoku());

        File chosenFileLocation = chooseSaveLocation(stage);
        exportSudoku.saveAsPDF(chosenFileLocation.getAbsolutePath());
    }

    @FXML
    public void view_ImportSudoku() { //todo: refactor
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sudoku-Bild auswählen");

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            char[][] recognized = SudokuSegmentationOCR.sudokuSegmentation(file.getAbsolutePath());
            sudokuViewActions.updateSudoku(recognized);
        }
    }

    @FXML
    private void updateSudoku(char[][] sudoku) {
        sudokuViewActions.updateSudoku(sudoku);
    }

    private File chooseSaveLocation(Stage stage) { //todo: refactor
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Speicherort auswählen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF-Dateien", "*.pdf"));

        File file = fileChooser.showSaveDialog(stage);
        return file;
    }

    @FXML
    public void view_BackHome() throws IOException {
        Object controller = Navigation.navigateTo(stage, "/org/example/sudokuapp/fxml/HomeScreen_View.fxml", "Sudoku App", 800, 700);
        ((HomeScreen_ViewController) controller).setStage(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
