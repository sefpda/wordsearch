package org.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordSearch {

    private String[] words;
    private String[] grid;

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
        boolean foundWord = false;
        int[] x = new int[this.grid.length];
        int[] y = new int[this.grid.length];
        for (int i = 0; i < this.grid.length; i++) {
            char[] column = new char[this.grid.length];

            for (int j = 0; j < this.grid.length; j++) {
                column[j] = this.grid[j].charAt(i);
            }

            String columnString = new String(column);
            if (columnString.contains(word)) {
                foundWord = true;
                for (int j = 0; j < word.length(); j++) {
                    x[j] = i;
                    y[j] = columnString.indexOf(word) + j;
                }
                break;
            }
        }
        return generateResult(word, x, y);
    }

    private String horizontalCoordinates(String word) {
        boolean foundWord = false;
        int[] x = new int[this.grid.length];
        int[] y = new int[this.grid.length];
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i].contains(word)) {
                foundWord = true;
                for (int j = 0; j < word.length(); j++) {
                    x[j] = this.grid[i].indexOf(word) + j;
                    y[j] = i;
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

            ArrayList<String> rows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            String header = rows.remove(0);
            this.words = header.split(",");

            this.grid = new String[rows.size()];

            for (int i = 0; i < rows.size(); i++) {
                this.grid[i] = rows.get(i).replace(",","");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
