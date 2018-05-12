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

        String row1 = new String(new char[]{rows[0].charAt(0), rows[1].charAt(1), rows[2].charAt(2), rows[3].charAt(3), rows[4].charAt(4)});
        if (row1.contains(word)) {
            int xoffset = row1.indexOf(word) + 0;
            int yoffset = row1.indexOf(word) + 0;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row2 = new String(new char[]{rows[0].charAt(1), rows[1].charAt(2), rows[2].charAt(3), rows[3].charAt(4)});
        if (row2.contains(word)) {
            int xoffset = row2.indexOf(word) + 1;
            int yoffset = row2.indexOf(word) + 0;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row3 = new String(new char[]{rows[0].charAt(2), rows[1].charAt(3), rows[2].charAt(4)});
        if (row3.contains(word)) {
            int xoffset = row3.indexOf(word) + 2;
            int yoffset = row3.indexOf(word) + 0;
            for (int i = 0; i < word.length(); i ++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row4 = new String(new char[]{rows[0].charAt(3), rows[1].charAt(4)});
        if (row4.contains(word)) {
            int xoffset = row4.indexOf(word) + 3;
            int yoffset = row4.indexOf(word) + 0;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row5 = new String(new char[]{rows[1].charAt(0),rows[2].charAt(1), rows[3].charAt(2), rows[4].charAt(3)});
        if (row5.contains(word)) {
            int xoffset = row5.indexOf(word) + 0;
            int yoffset = row5.indexOf(word) + 1;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row6 = new String(new char[]{rows[2].charAt(0), rows[3].charAt(1), rows[4].charAt(2)});
        if (row6.contains(word)) {
            int xoffset = row6.indexOf(word) + 0;
            int yoffset = row6.indexOf(word) + 2;
            for (int i = 0; i < word.length(); i++) {
                x[i] = i + xoffset;
                y[i] = i + yoffset;
            }
            return generateResult(word, x, y);
        }

        String row7 = new String(new char[]{rows[3].charAt(0), rows[4].charAt(1)});
        if (row7.contains(word)) {
            int xoffset = row7.indexOf(word) + 0;
            int yoffset = row7.indexOf(word) + 3;
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
