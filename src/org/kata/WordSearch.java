package org.kata;

import java.io.IOException;
import java.lang.reflect.Array;
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
        return downwardDiagonal(word);
    }

    private String downwardDiagonal(String word) {
        boolean xStable = false;
        boolean yStable = false;
        return findCoordinates(this.rows, this.columns, word);
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

    private String findCoordinates(String[] rows, String[] columns, String word) {
//        boolean foundWord = false;
        int[] x = new int[rows.length];
        int[] y = new int[columns.length];

        int startX = 0;
        int startY = 0;
        char[] letters = new char[rows.length];

        for (int i = 0; i < letters.length; i++) {
           letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row1 = new String(letters);
        if (row1.contains(word)) {
            int xoffset = row1.indexOf(word) + startX;
            int yoffset = row1.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 1;
        startY = 0;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row2 = new String(letters);
        if (row2.contains(word)) {
            int xoffset = row2.indexOf(word) + startX;
            int yoffset = row2.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 2;
        startY = 0;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row3 = new String(letters);
        if (row3.contains(word)) {
            int xoffset = row3.indexOf(word) + startX;
            int yoffset = row3.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i ++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 3;
        startY = 0;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row4 = new String(letters);
        if (row4.contains(word)) {
            int xoffset = row4.indexOf(word) + startX;
            int yoffset = row4.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 0;
        startY = 1;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length && startY + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row5 = new String(letters);
        if (row5.contains(word)) {
            int xoffset = row5.indexOf(word) + startX;
            int yoffset = row5.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 0;
        startY = 2;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length && startY + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row6 = new String(letters);
        if (row6.contains(word)) {
            int xoffset = row6.indexOf(word) + startX;
            int yoffset = row6.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        startX = 0;
        startY = 3;
        Arrays.fill(letters, ' ');
        for (int i = 0; i < letters.length && startX + i < letters.length && startY + i < letters.length; i++) {
            letters[i] = rows[startY + i].charAt(startX + i);
        }
        String row7 = new String(letters);
        if (row7.contains(word)) {
            int xoffset = row7.indexOf(word) + startX;
            int yoffset = row7.indexOf(word) + startY;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

//        if (!foundWord) return null;
//        return generateResult(word, x, y);
        return null;
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
