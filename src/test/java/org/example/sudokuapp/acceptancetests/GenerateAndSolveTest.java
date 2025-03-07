package org.example.sudokuapp.acceptancetests;

import org.example.sudokuapp.logic.algorithm.GeneratingSudoku;
import org.example.sudokuapp.logic.algorithm.SudokuSolver;
import org.example.sudokuapp.logic.misc.Sudoku;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateAndSolveTest {

    public static Stream<Arguments> provideSudokus() {
        GeneratingSudoku generator = new GeneratingSudoku();

        return Stream.of(
                Arguments.of(generator.generateSudoku(100)),
                Arguments.of(generator.generateSudoku(500)),
                Arguments.of(generator.generateSudoku(1000),
                        Arguments.of(generator.generateSudoku(10))
                ));
    }

    @ParameterizedTest(name = "Solving sudoku {0}")
    @MethodSource("provideSudokus")
    void solveSudoku(Sudoku sudoku) {
        SudokuSolver solver = new SudokuSolver();
        System.out.println("Generated Sudoku:");
        for (char[] row : sudoku.getSudoku()) {
            System.out.println(row);
        }

        Sudoku actual = solver.solve(sudoku);

        assertThat(actual).isNotNull();
    }
}
