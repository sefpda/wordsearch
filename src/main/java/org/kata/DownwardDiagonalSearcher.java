package org.kata;

import java.util.List;

class DownwardDiagonalSearcher extends AbstractDiagonalSearcher {

    private static DownwardDiagonalSearcher INSTANCE;

    private DownwardDiagonalSearcher() {}

    static DownwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new DownwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    @Override
    List<Result> findCoordinates(String[] rows, String word) {
        return findCoordinatesAlongDiagonalLine(rows, word);
    }

    protected int limitY(String[] rows) {
        return rows.length - 1;
    }

    protected int startRow(String[] rows) {
        return 0;
    }
    protected short deltaY() {
        return 1;
    }

    protected boolean continueWhileY(int y, int limit) {
        return y < limit;
    }

    protected boolean shouldSkip(int x, int y, String[] rows) {
        return y > 0 && x > 0;
    }

    protected boolean continueCollectingWhile(int x, int y, int i, char[] letters) {
        return i < letters.length && x + i < letters.length && y + i < letters.length;
    }

    protected int rowIndex(int y, int i) {
        return y + i;
    }

    protected int yOffset(int y, String word, String row) {
        return row.indexOf(word) + y;
    }

    protected int applyOffsetY(int offset, int index) {
        return index + offset;
    }

}
