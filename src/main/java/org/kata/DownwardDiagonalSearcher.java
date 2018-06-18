package org.kata;

import java.util.ArrayList;
import java.util.List;

class DownwardDiagonalSearcher extends AbstractSearcher {

    private static DownwardDiagonalSearcher INSTANCE;

    private DownwardDiagonalSearcher() {}

    static DownwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new DownwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    List<Result> findCoordinates(String[] rows, String word) {
        int[] x = new int[rows.length];
        int[] y = new int[rows.length];

        short deltaY = 1;
        int startRow = 0;
        int limitY = rows.length - 1;

        List<Result> results = new ArrayList<Result>();
        for (int startY = startRow; continueWhileY(startY, limitY); startY += deltaY) {
            for (int startX = 0; startX < rows.length - 1; startX++) {
                if (shouldSkip(startX, startY, rows)) continue;
                char[] letters = new char[rows.length];
                for (int i = 0; continueCollectingWhile(startX, startY, i, letters); i++) {
                    letters[i] = rows[rowIndex(startY, i)].charAt(startX + i);
                }
                String row = new String(letters);
                if (row.contains(word)) {
                    int xOffset = row.indexOf(word) + startX;
                    int yOffset = yOffset(startY, word, row);
                    for (int j = 0; j < word.length(); j++) {
                        x[j] = j + xOffset;
                        y[j] = applyOffsetY(yOffset, j);
                    }
                    results.add(new Result(word, x, y));
                    x = new int[rows.length];
                    y = new int[rows.length];
                }
            }
        }
        return results;
    }

    private boolean continueWhileY(int y, int limit) {
        return y < limit;
    }

    private boolean shouldSkip(int x, int y, String[] rows) {
        return y > 0 && x > 0;
    }

    private boolean continueCollectingWhile(int x, int y, int i, char[] letters) {
        return i < letters.length && x + i < letters.length && y + i < letters.length;
    }

    private int rowIndex(int y, int i) {
        return y + i;
    }

    private int yOffset(int y, String word, String row) {
        return row.indexOf(word) + y;
    }

    private int applyOffsetY(int offset, int index) {
        return index + offset;
    }

}
