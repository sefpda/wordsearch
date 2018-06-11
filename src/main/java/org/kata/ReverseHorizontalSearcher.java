package org.kata;

class ReverseHorizontalSearcher extends AbstractSearcher {

    private static ReverseHorizontalSearcher INSTANCE;

    private ReverseHorizontalSearcher() {}

    static ReverseHorizontalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseHorizontalSearcher();
        }
        return INSTANCE;
    }

    String[] findCoordinates(String[] source, String word) {
        boolean xStable = false;
        boolean yStable = true;
        return new String[]{findReverseCoordinatesAlongStraightLine(source, word, xStable, yStable)};
    }
}
