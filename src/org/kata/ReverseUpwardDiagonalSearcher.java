package org.kata;

public class ReverseUpwardDiagonalSearcher extends AbstractSearcher {

    private static ReverseUpwardDiagonalSearcher INSTANCE;

    private ReverseUpwardDiagonalSearcher() {}

    static ReverseUpwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseUpwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] rows, String word) {
        boolean foundWord = false;
        int[] x = new int[rows.length];
        int[] y = new int[rows.length];
        for (int startY = rows.length - 1; startY > 0; startY--) {
            for (int startX = 0; startX < rows.length - 1; startX++) {
                if (startY < rows.length - 1 && startX > 0) continue; // only go past x 0 for last row
                char[] letters = new char[rows.length];
                for (int i = 0; i < letters.length && startX + i < letters.length && startY - i > -1; i++) {
                    letters[i] = rows[startY - i].charAt(startX + i);
                }
                String reversed = new StringBuilder(word).reverse().toString();
                String row = new String(letters);
                if (row.contains(reversed)) {
                    int xOffset = row.indexOf(reversed) + reversed.length() + startX - 1;
                    int yOffset = row.indexOf(reversed) + startX;
                    for (int j = 0; j < word.length(); j++) {
                        x[j] = xOffset - j;
                        y[j] = yOffset + j;
                    }
                    foundWord = true;
                    break;
                }
            }
        }
        if (!foundWord) return null;
        return generateResult(word, x, y);
    }
}
