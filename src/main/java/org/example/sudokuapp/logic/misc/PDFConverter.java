package org.example.sudokuapp.logic.misc;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PDFConverter {

    public PDFConverter() {
    }

    public void convertSudokuToPDF(String fullPath, char[][] sudoku) {
        String html = getHtmlCode(sudoku);

        try (OutputStream os = new FileOutputStream(fullPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(html, new File(".").toURI().toString());
            builder.toStream(os);
            builder.run();
            System.out.println("PDF wurde erfolgreich erstellt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getHtmlCode(char[][] sudoku) {
        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                        <html lang="de">
                        <head>
                          <meta charset="UTF-8" />
                          <title>Sudoku Raster</title>
                          <style>
                            table {
                              border-collapse: collapse;
                              margin: 20px auto;
                            }
                            td {
                              width: 40px;
                              height: 40px;
                              text-align: center;
                              vertical-align: middle;
                              border: 1px solid #999;
                              font-size: 20px;
                            }
                            tr:nth-child(3n) td {
                              border-bottom: 2px solid #000;
                            }
                            tr:first-child td {
                              border-top: 2px solid #000;
                            }
                            td:nth-child(3n) {
                              border-right: 2px solid #000;
                            }
                            td:first-child {
                              border-left: 2px solid #000;
                            }
                          </style>
                        </head>
                        <body>
                          <table>
                """);

        for (char[] row : sudoku) {
            html.append("<tr>");
            for (char c : row) {
                if (c == '\u0000') {
                    html.append("<td></td>");
                } else {
                    html.append("<td>").append(c).append("</td>");
                }
            }
            html.append("</tr>");
        }

        html.append("""
                </table>
                        </body>
                        </html>
                """);
        return html.toString();
    }
}
