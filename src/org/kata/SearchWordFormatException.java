package org.kata;

class SearchWordFormatException extends RuntimeException {

    SearchWordFormatException() {
        super("Words must be no smaller than 2 characters in length");
    }
}
