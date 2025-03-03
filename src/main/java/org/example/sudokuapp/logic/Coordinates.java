package org.example.sudokuapp.logic;

public record Coordinates(int y, int x) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) obj;
        return y == that.y && x == that.x;
    }

}
