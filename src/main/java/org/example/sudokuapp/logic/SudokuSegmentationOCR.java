package org.example.sudokuapp.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.example.sudokuapp.logic.SudokuOCR.performOCR;

public class SudokuSegmentationOCR {

    public static char[][] sudokuSegmentation(String path) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));

            int rows = 9;
            int cols = 9;

            int cellWidth = originalImage.getWidth() / cols;
            int cellHeight = originalImage.getHeight() / rows;

            File outputDir = new File("output_cells");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            char[][] sudokuArray = new char[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int x = col * cellWidth;
                    int y = row * cellHeight;

                    BufferedImage cellImage = originalImage.getSubimage(x, y, cellWidth, cellHeight);
                    cellImage = cellImage.getSubimage(10, 10, cellImage.getWidth() - 20, cellImage.getHeight() - 20);

                    char recognizedChar = performOCR(cellImage);
                    sudokuArray[row][col] = recognizedChar;

                    File outputFile = new File(outputDir, "cell_" + row + "_" + col + ".png");
                    ImageIO.write(cellImage, "png", outputFile);
                }
            }

        return sudokuArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
