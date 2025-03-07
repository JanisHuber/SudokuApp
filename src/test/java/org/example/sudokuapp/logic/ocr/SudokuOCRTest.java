package org.example.sudokuapp.logic.ocr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuOCRTest {

    private static final Logger log = LoggerFactory.getLogger(SudokuOCRTest.class);

    private static Stream<Arguments> provideOCRCases() {
        return Stream.of(
                Arguments.of("src/main/resources/testimages/test01.png", new char[][]{
                        {0, '9', '4', 0, 0, 0, '8', '3', 0},
                        {0, 0, '2', '3', 0, '6', '7', '4', 0},
                        {0, '5', '7', '2', '8', 0, '1', 0, 0},
                        {'2', 0, 0, '4', 0, 0, 0, 0, 0},
                        {'5', 0, '1', '7', 0, 0, '4', '2', '9'},
                        {0, 0, 0, '9', '2', '8', 0, '6', 0},
                        {'1', '3', 0, 0, 0, 0, '9', '8', 0},
                        {0, '4', '6', '8', '3', '1', 0, '5', 0},
                        {0, 0, '8', 0, 0, 0, 0, 0, 0}
                }),
                Arguments.of("src/main/resources/testimages/test02.png", new char[][]{
                        {0, 0, '3', 0, 0, '6', '4', '2', 0},
                        {'2', '5', 0, '7', 0, 0, '6', '8', 0},
                        {0, 0, 0, '2', '3', 0, '9', 0, 0},
                        {'1', 0, 0, '4', '7', '3', '5', 0, 0},
                        {'4', 0, '9', '5', 0, 0, '1', '3', '2'},
                        {0, 0, 0, '9', '2', '1', 0, 0, 0},
                        {'3', '4', '5', 0, '9', 0, '8', '7', 0},
                        {'7', 0, '6', '1', '8', 0, 0, 0, '9'},
                        {0, '9', 0, 0, 0, 0, 0, 0, 0}
                }));
    }

    @ParameterizedTest
    @MethodSource("provideOCRCases")
    void testOCR(String path, char[][] expected) {
        char[][] actual = SudokuSegmentationOCR.sudokuSegmentation(path);

        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                if (actual[i][j] == '\u0000' || actual[i][j] == ' ') {
                    actual[i][j] = '0';
                }
            }
        }

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] == '\u0000' || expected[i][j] == ' ') {
                    expected[i][j] = '0';
                }
            }
        }

        assertThat(Arrays.deepEquals(actual, expected)).isTrue();
    }
}