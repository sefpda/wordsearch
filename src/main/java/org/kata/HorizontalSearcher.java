package org.kata;

import java.util.List;

class HorizontalSearcher extends AbstractStraightSearcher {

    private static HorizontalSearcher INSTANCE;

    private HorizontalSearcher() {}

    static HorizontalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new HorizontalSearcher();
        }
        return INSTANCE;
    }

    List<Result> findCoordinates(String[] source, String word) {
        boolean xStable = false;
        boolean yStable = true;
        return findCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
