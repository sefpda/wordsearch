package org.kata;

import java.util.List;

class VerticalSearcher extends AbstractStraightSearcher {

    private static VerticalSearcher INSTANCE;

    private VerticalSearcher() {}

    static VerticalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new VerticalSearcher();
        }
        return INSTANCE;
    }

    List<Result> findCoordinates(String[] source, String word) {
        boolean xStable = true;
        boolean yStable = false;
        return findCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
