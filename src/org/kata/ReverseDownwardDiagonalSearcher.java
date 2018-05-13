package org.kata;

public class ReverseDownwardDiagonalSearcher extends AbstractSearcher {

    private static ReverseDownwardDiagonalSearcher INSTANCE;

    private ReverseDownwardDiagonalSearcher() {}

    static ReverseDownwardDiagonalSearcher instance() {
        if (INSTANCE == null) {
            INSTANCE = new ReverseDownwardDiagonalSearcher();
        }
        return INSTANCE;
    }

    String findCoordinates(String[] rows, String word) {
        boolean foundWord = false;
        int[] x = new int[rows.length];
        int[] y = new int[rows.length];
        String reversed = new StringBuilder(word).reverse().toString();
        for (int startY = 0; startY < rows.length - 1; startY++) {
            for (int startX = 0; startX < rows.length - 1; startX++) {
                if (startY > 0 && startX > 0) continue; // after first row only start at x of 0
                char[] letters = new char[rows.length];
                for (int i = 0; i < letters.length && startX + i < letters.length && startY + i < letters.length; i++) {
                    letters[i] = rows[startY + i].charAt(startX + i);
                }
                String row = new String(letters);
                if (row.contains(reversed)) {
                    int xOffset = reversed.length() + row.indexOf(reversed) - 1;
                    int yOffset = reversed.length() + row.indexOf(reversed) - 1;
                    for (int j = 0; j < reversed.length(); j++) {
                        x[j] = xOffset - j;
                        y[j] = yOffset - j;
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
