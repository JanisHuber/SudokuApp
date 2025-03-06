package org.example.sudokuapp.logic.ocr;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class SudokuOCR {

    public static char performOCR(BufferedImage image) {
        ITesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\janis\\OneDrive - Privat\\2024\\Privat\\Projekte\\SudokuApp\\src\\main\\resources\\tessdata");
        System.setProperty("TESSDATA_PREFIX", "C:\\Users\\janis\\OneDrive - Privat\\2024\\Privat\\Projekte\\SudokuApp\\src\\main\\resources");

        instance.setLanguage("digits");
        instance.setTessVariable("tessedit_char_whitelist", "123456789");
        instance.setTessVariable("classify_bln_numeric_mode", "1");

        instance.setPageSegMode(ITessAPI.TessPageSegMode.PSM_SINGLE_CHAR);

        try {
            String recognizedText = instance.doOCR(image).trim();
            if (recognizedText.isEmpty()) {
                System.err.println("Zelle leer");
                return ' ';
            }
            if (recognizedText.charAt(0) == '9') {
                instance.setLanguage("eng");
                recognizedText = instance.doOCR(image).trim();
                return recognizedText.charAt(0);
            }
            return recognizedText.charAt(0);
        } catch (TesseractException e) {
            e.printStackTrace();
            return ' ';
        }
    }
}
