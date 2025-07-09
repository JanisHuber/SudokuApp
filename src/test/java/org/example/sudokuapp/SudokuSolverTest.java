package org.example.sudokuapp;

import org.example.sudokuapp.logic.algorithm.SudokuSolver;
import org.example.sudokuapp.logic.misc.Sudoku;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuSolverTest {
    public static Stream<Arguments> provideSudokusInput() {
        return Stream.of(
                Arguments.of(new Sudoku(new char[][]{
                        {'5', '3', 0, 0, '7', 0, 0, 0, 0},
                        {'6', 0, 0, '1', '9', '5', 0, 0, 0},
                        {0, '9', '8', 0, 0, 0, 0, '6', 0},
                        {'8', 0, 0, 0, '6', 0, 0, 0, '3'},
                        {'4', 0, 0, '8', 0, '3', 0, 0, '1'},
                        {'7', 0, 0, 0, '2', 0, 0, 0, '6'},
                        {0, '6', 0, 0, 0, 0, '2', '8', 0},
                        {0, 0, 0, '4', '1', '9', 0, 0, '5'},
                        {0, 0, 0, 0, '8', 0, 0, '7', '9'}
                }), new Sudoku(new char[][]{
                        {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                        {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                        {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                        {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                        {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                        {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                        {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                        {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                        {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
                })),
                Arguments.of(new Sudoku(new char[][]{
                        {0, 0, 0, '2', '6', 0, '7', 0, '1'},
                        {'6', '8', 0, 0, '7', 0, 0, '9', 0},
                        {'1', '9', 0, 0, 0, '4', '5', 0, 0},
                        {'8', '2', 0, '1', 0, 0, 0, '4', 0},
                        {0, 0, '4', '6', 0, '2', '9', 0, 0},
                        {0, '5', 0, 0, 0, '3', 0, '2', '8'},
                        {0, 0, '9', '3', 0, 0, 0, '7', '4'},
                        {0, '4', 0, 0, '5', 0, 0, '3', '6'},
                        {'7', 0, '3', 0, '1', '8', 0, 0, 0}
                }), new Sudoku(new char[][]{
                        {'4', '3', '5', '2', '6', '9', '7', '8', '1'},
                        {'6', '8', '2', '5', '7', '1', '4', '9', '3'},
                        {'1', '9', '7', '8', '3', '4', '5', '6', '2'},
                        {'8', '2', '6', '1', '9', '5', '3', '4', '7'},
                        {'3', '7', '4', '6', '8', '2', '9', '1', '5'},
                        {'9', '5', '1', '7', '4', '3', '6', '2', '8'},
                        {'5', '1', '9', '3', '2', '6', '8', '7', '4'},
                        {'2', '4', '8', '9', '5', '7', '1', '3', '6'},
                        {'7', '6', '3', '4', '1', '8', '2', '5', '9'}
                })),
                Arguments.of(new Sudoku(new char[][]{
                        {'1', 0, 0, '4', '8', '9', 0, 0, '6'},
                        {'7', '3', 0, 0, 0, 0, 0, '4', 0},
                        {0, 0, 0, 0, 0, '1', '2', '9', '5'},
                        {0, 0, '7', '1', '2', 0, '6', 0, 0},
                        {'5', 0, 0, '7', 0, '3', 0, 0, '8'},
                        {0, 0, '6', 0, '9', '5', '7', 0, 0},
                        {'9', '1', '4', '6', 0, 0, 0, 0, 0},
                        {0, '2', 0, 0, 0, 0, 0, '3', '7'},
                        {'8', 0, 0, '5', '1', '2', 0, 0, '4'}
                }), new Sudoku(new char[][]{
                        {'1', '5', '2', '4', '8', '9', '3', '7', '6'},
                        {'7', '3', '9', '2', '5', '6', '8', '4', '1'},
                        {'4', '6', '8', '3', '7', '1', '2', '9', '5'},
                        {'3', '8', '7', '1', '2', '4', '6', '5', '9'},
                        {'5', '9', '1', '7', '6', '3', '4', '2', '8'},
                        {'2', '4', '6', '8', '9', '5', '7', '1', '3'},
                        {'9', '1', '4', '6', '3', '7', '5', '8', '2'},
                        {'6', '2', '5', '9', '4', '8', '1', '3', '7'},
                        {'8', '7', '3', '5', '1', '2', '9', '6', '4'}
                }))
        );
    }

    @ParameterizedTest(name = "Sudoku {index}")
    @MethodSource("provideSudokusInput")
    void testSolver(Sudoku input, Sudoku expected) {
        SudokuSolver solver = new SudokuSolver();

        Sudoku actual = solver.solve(input);

        System.out.println("Expected: " + Arrays.deepToString(expected.getCharArray()));
        System.out.println("Actual: " + Arrays.deepToString(actual.getCharArray()));
        assertThat(actual).isEqualTo(expected);
    }
}