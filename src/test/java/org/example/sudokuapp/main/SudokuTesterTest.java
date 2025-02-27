/*package org.example.sudokuapp.main;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Argument;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTesterTest {

    private static Stream<Arguments> provideSudokus() {
        return Stream.of(
                Arguments.of(getSudoku(), true;
                }, true)
        );
    }



    @ParameterizedTest()
    @MethodSource("provideSudokus")

    void testIsSudokuValid(char[][] sudoku, boolean expected) {
        Sudoku sudokuObj = new Sudoku(sudoku);
        assertEquals(expected, SudokuTester.isSolvedSudokuValid(sudokuObj));
    }
}*/