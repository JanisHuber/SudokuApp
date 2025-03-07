package org.example.sudokuapp.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.sudokuapp.logic.algorithm.GeneratingSudoku;
import org.example.sudokuapp.logic.algorithm.SudokuSolver;
import org.example.sudokuapp.logic.misc.Sudoku;
import org.example.sudokuapp.logic.misc.SudokuValidator;
import org.example.sudokuapp.ui.Dialog;
import org.example.sudokuapp.ui.Navigation;
import org.example.sudokuapp.ui.SudokuViewActions;

import java.io.File;
import java.io.IOException;


public class GenerateSudoku_ViewController {
    @FXML
    TextField txtField_SudokuDifficulty;
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
    public void view_VerifySolution() { //todo: refactor
        Sudoku inputSudoku = new Sudoku(sudokuViewActions.getSudoku());
        String title;
        String content;

        if (inputSudoku.getFilledAmountOfCells() < 81) {
            title = "Invalid Sudoku";
            content = "The Sudoku is not valid. Please fill in all fields.";
            Dialog.showDialog(title, content);
            return;
        }

        title = SudokuValidator.validate(inputSudoku.getSudoku()) ? "Sudoku Solved" : "Sudoku Not Solved";
        content = SudokuValidator.validate(inputSudoku.getSudoku()) ? "The Sudoku has been solved correctly." : "The Sudoku has not been solved correctly.";
        Dialog.showDialog(title, content);
    }

    @FXML
    public void view_BackHome() throws IOException {
        Object controller = Navigation.navigateTo(stage, "/org/example/sudokuapp/fxml/HomeScreen_View.fxml", "Sudoku App", 800, 700);
        ((HomeScreen_ViewController) controller).setStage(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void view_ExportSudoku() {
        Sudoku exportSudoku = new Sudoku(sudokuViewActions.getSudoku());

        File chosenFileLocation = chooseSaveLocation(stage);
        exportSudoku.saveAsPDF(chosenFileLocation.getAbsolutePath());
    }

    @FXML
    public void view_GetTipp() {
        char[][] outputSudoku = solver.getNextStep(sudokuViewActions.getSudoku());

        sudokuViewActions.updateSudoku(outputSudoku);
    }

    @FXML
    public void view_GenerateSudoku() {
        GeneratingSudoku generatingSudoku = new GeneratingSudoku();

        Sudoku generatedSudoku = generatingSudoku.generateSudoku(Integer.parseInt(txtField_SudokuDifficulty.getText()));
        sudokuViewActions.updateSudoku(generatedSudoku.getSudoku());
    }

    private File chooseSaveLocation(Stage stage) { //todo: refactor
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Speicherort auswählen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF-Dateien", "*.pdf"));

        File file = fileChooser.showSaveDialog(stage);
        return file;
    }
}
