package org.kata;

public class DownwardDiagonalSearcher extends AbstractSearcher {

    private static DownwardDiagonalSearcher INSTANCE;

    private DownwardDiagonalSearcher() {}

    static DownwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new DownwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] rows, String word) {
        boolean foundWord = false;
        int[] x = new int[rows.length];
        int[] y = new int[rows.length];
        for (int startY = 0; startY < rows.length - 1; startY++) {
            for (int startX = 0; startX < rows.length - 1; startX++) {
                if (startY > 0 && startX > 0) continue; // after first row only start at x of 0
                char[] letters = new char[rows.length];
                for (int i = 0; i < letters.length && startX + i < letters.length && startY + i < letters.length; i++) {
                    letters[i] = rows[startY + i].charAt(startX + i);
                }
                String row = new String(letters);
                if (row.contains(word)) {
                    int xOffset = row.indexOf(word) + startX;
                    int yOffset = row.indexOf(word) + startY;
                    for (int j = 0; j < word.length(); j++) {
                        x[j] = j + xOffset;
                        y[j] = j + yOffset;
                    }
                    foundWord = true;
                    break;
                }
            }
        }
        return generateResult(word, x, y);
    }

}
