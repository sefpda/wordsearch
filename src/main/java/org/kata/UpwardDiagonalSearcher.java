package org.kata;

class UpwardDiagonalSearcher extends AbstractDiagonalSearcher {

    private static UpwardDiagonalSearcher INSTANCE;

    private UpwardDiagonalSearcher() {}

    static UpwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new UpwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    protected short deltaY() {
        return -1;
    }

    protected int limitY(String[] rows) {
        return 0;
    }

    protected int startRow(String[] rows) {
        return rows.length - 1;
    }

    protected int yOffset(int y, String word, String row) {
        return y - row.indexOf(word);
    }

    protected boolean shouldSkip(int startX, int startY, String[] rows) {
        return startY < rows.length - 1 && startX > 0;
    }

    protected boolean continueWhileY(int y, int limit) {
        return y > limit;
    }

    protected boolean continueCollectingWhile(int x, int y, int i, char[] letters) {
        return i < letters.length && x + i < letters.length && y - i > -1;
    }

    protected int rowIndex(int y, int i) {
        return y - i;
    }

    protected int applyOffsetY(int offset, int index) {
        return offset - index;
    }

}
