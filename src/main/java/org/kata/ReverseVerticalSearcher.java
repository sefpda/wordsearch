package org.kata;

import java.util.List;

class ReverseVerticalSearcher extends AbstractSearcher {

    private static ReverseVerticalSearcher INSTANCE;

    private ReverseVerticalSearcher() {}

    static ReverseVerticalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseVerticalSearcher();
        }
        return INSTANCE;
    }

    List<Result> findCoordinates(String[] source, String word) {
        boolean xStable = true;
        boolean yStable = false;
        return findReverseCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
