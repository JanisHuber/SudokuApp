package org.example.sudokuapp.logic.misc;

public class Cell {
    private char value;
    private Coordinates coordinates;

    public Cell(char value, Coordinates coordinates) {
        this.value = value;
        this.coordinates = coordinates;
    }

    public char getChar() {
        return value;
    }

    public void setCell(char value) {
        this.value = value;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isFilled() {
        return value != '\u0000' && Character.getNumericValue(value) != 0 && Character.getNumericValue(value) > 0 && Character.getNumericValue(value) <= 9;
    }
}
