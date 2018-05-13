package org.kata;

public class ReverseHorizontalSearcher extends AbstractSearcher {

    private static ReverseHorizontalSearcher INSTANCE;

    private ReverseHorizontalSearcher() {}

    static ReverseHorizontalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseHorizontalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] source, String word) {
        boolean xStable = false;
        boolean yStable = true;
        return findReverseCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
