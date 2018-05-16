package org.kata;

class ReverseVerticalSearcher extends AbstractSearcher {

    private static ReverseVerticalSearcher INSTANCE;

    private ReverseVerticalSearcher() {}

    static ReverseVerticalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseVerticalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] source, String word) {
        boolean xStable = true;
        boolean yStable = false;
        return findReverseCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
