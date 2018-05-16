package org.kata;

public class InvalidGridException extends RuntimeException {
    public InvalidGridException(int size) {
        super("Grids must be square. With " + size + " rows, there should be " + size + " columns.");
    }
}
