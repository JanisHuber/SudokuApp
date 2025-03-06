package org.example.sudokuapp.logic.sudokugenerating;

import org.example.sudokuapp.logic.algorithm.GeneratingSudoku;
import org.example.sudokuapp.logic.misc.Sudoku;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeneratingSudokuTest {

    public static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.of(100),
                Arguments.of(50),
                Arguments.of(10),
                Arguments.of(0)
        );
    }

    @ParameterizedTest()
    @MethodSource("provideInputs")
    void testGenerateSudoku(int difficulty) {
        GeneratingSudoku generatingSudoku = new GeneratingSudoku();

        Sudoku actual = generatingSudoku.generateSudoku(difficulty);

        assertNotNull(actual);
    }
}