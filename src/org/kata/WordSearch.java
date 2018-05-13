package org.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordSearch {

    private String[] words;
    private String[] rows;
    private String[] columns;

    public static void main(String[] args) {
        // write your code here
    }

    public WordSearch(String fileName) {
        loadPuzzle(fileName);
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();

        for (String word: this.words) {
            results.add(coordinates(word));
        }

        return results;
    }

    private String coordinates(String word) {
        String horizontalResult = horizontalCoordinates(word);
        if (horizontalResult != null) return horizontalResult;
        String verticalResult = verticalResult(word);
        if (verticalResult != null) return verticalResult;
        String downDiagonal = downwardDiagonal(word);
        if (downDiagonal != null) return downDiagonal;
        return upDiagonal(word);
    }

    private String upDiagonal(String word) {
        boolean yUp = true;
        return findDiagonalCoordinates(this.rows, word, yUp);
    }

    private String downwardDiagonal(String word) {
        boolean yUp = false;
        return findDiagonalCoordinates(this.rows, word, yUp);
    }

    private String verticalResult(String word) {
        boolean xStable = true;
        boolean yStable = false;

        return findCoordinates(this.columns, word, xStable, yStable);
    }

    private String horizontalCoordinates(String word) {
        boolean xStable = false;
        boolean yStable = true;

        return findCoordinates(this.rows, word, xStable, yStable);
    }

    private String findDiagonalCoordinates(String[] rows, String word, boolean yUp) {
        if (yUp) {
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
                    String row = new String(letters);
                    if (row.contains(word)) {
                        int xOffset = row.indexOf(word) + startX;
                        int yOffset = row.indexOf(word) + startY;
                        for (int j = 0; j < word.length(); j++) {
                            x[j] = j + xOffset;
                            y[j] = yOffset - j;
                        }
                        foundWord = true;
                        break;
                    }
                }
            }
            if (!foundWord) return null;
            return generateResult(word, x, y);
        } else {
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
            if (!foundWord) return null;
            return generateResult(word, x, y);
        }
    }

    private String findCoordinates(String[] source, String word, boolean xStable, boolean yStable) {
        boolean foundWord = false;
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(word)) {
                foundWord = true;
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(word) + j;
                    y[j] = yStable ? i : source[i].indexOf(word) + j;
                }
                break;
            }
        }
        if (!foundWord) return null;
        return generateResult(word, x, y);
    }

    private String generateResult(String word, int[] x, int[] y) {
        StringBuilder result = new StringBuilder(word);
        result.append(": ");
        for (int i = 0; i < word.length(); i++) {
            if (i > 0) result.append(",");
            result.append("(");
            result.append(x[i]);
            result.append(",");
            result.append(y[i]);
            result.append(")");
        }
        return result.toString();
    }

    private void loadPuzzle(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> inputRows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            String header = inputRows.remove(0);
            this.words = header.split(",");

            this.rows = new String[inputRows.size()];
            this.columns = new String[inputRows.size()];

            for (int i = 0; i < inputRows.size(); i++) {
                this.rows[i] = inputRows.get(i).replace(",","");
            }
            for (int i = 0; i < inputRows.size(); i++) {
                char[] column = new char[this.rows.length];

                for (int j = 0; j < this.rows.length; j++) {
                    column[j] = this.rows[j].charAt(i);
                }
                this.columns[i] = new String(column);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
