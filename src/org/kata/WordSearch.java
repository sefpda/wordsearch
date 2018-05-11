package org.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        return verticalResult(word);
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
