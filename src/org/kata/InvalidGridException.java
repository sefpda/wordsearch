package org.kata;

class InvalidGridException extends RuntimeException {
    InvalidGridException(int size) {
        super("Grids must be square. With " + size + " rows, there should be " + size + " columns.");
    }
}
