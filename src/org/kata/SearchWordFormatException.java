package org.kata;

public class SearchWordFormatException extends RuntimeException {

    public SearchWordFormatException() {
        super("Words must be no smaller than 2 characters in length");
    }
}
