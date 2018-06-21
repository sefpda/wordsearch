package org.kata;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDiagonalSearcher extends AbstractSearcher {

    final protected List<Result> findCoordinatesAlongDiagonalLine(String[] rows, String word) {
        int[] x = new int[rows.length];
        int[] y = new int[rows.length];

        short deltaY = deltaY();
        int startRow = startRow(rows);
        int limitY = limitY(rows);

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

    protected abstract int applyOffsetY(int offset, int index);

    protected abstract int yOffset(int y, String word, String row);

    protected abstract int rowIndex(int y, int i);

    protected abstract boolean continueCollectingWhile(int x, int y, int i, char[] letters);

    protected abstract boolean shouldSkip(int x, int y, String[] rows);

    protected abstract boolean continueWhileY(int y, int limit);

    protected abstract int startRow(String[] rows);

    protected abstract short deltaY();

    protected abstract int limitY(String[] rows);
}
