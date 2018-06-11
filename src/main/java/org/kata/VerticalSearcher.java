package org.kata;

class VerticalSearcher extends AbstractSearcher {

    private static VerticalSearcher INSTANCE;

    private VerticalSearcher() {}

    static VerticalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new VerticalSearcher();
        }
        return INSTANCE;
    }

    String[] findCoordinates(String[] source, String word) {
        boolean xStable = true;
        boolean yStable = false;
        return new String[]{findCoordinatesAlongStraightLine(source, word, xStable, yStable)};
    }
}
