package org.kata;

import java.util.List;

class HorizontalSearcher extends AbstractSearcher {

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
        return findMultipleCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
