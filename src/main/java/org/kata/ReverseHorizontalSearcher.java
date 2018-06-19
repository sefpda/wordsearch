package org.kata;

import java.util.List;

class ReverseHorizontalSearcher extends AbstractStraightSearcher {

    private static ReverseHorizontalSearcher INSTANCE;

    private ReverseHorizontalSearcher() {}

    static ReverseHorizontalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseHorizontalSearcher();
        }
        return INSTANCE;
    }

    List<Result> findCoordinates(String[] source, String word) {
        boolean xStable = false;
        boolean yStable = true;
        return findReverseCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
