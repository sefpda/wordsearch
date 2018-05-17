package org.kata;

class HorizontalSearcher extends AbstractSearcher {

    private static HorizontalSearcher INSTANCE;

    private HorizontalSearcher() {}

    static HorizontalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new HorizontalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] source, String word) {
        boolean xStable = false;
        boolean yStable = true;
        return findCoordinatesAlongStraightLine(source, word, xStable, yStable);
    }
}
