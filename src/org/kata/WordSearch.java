package org.kata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordSearch {

    private String header;
    private String[] grid;

    public static void main(String[] args) {
        // write your code here
    }

    public WordSearch(String fileName) {
        loadPuzzle(fileName);
    }

    public List<String> getResults() {

        int[] x = new int[this.grid.length];
        int[] y = new int[this.grid.length];
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i].contains(this.header)) {
                for (int j = 0; j < this.header.length(); j++) {
                    x[j] = this.grid[i].indexOf(this.header) + j;
                    y[j] = i;
                }
                break;
            }
        }

        ArrayList<String> results = new ArrayList<>();
        StringBuilder result = new StringBuilder(this.header);
        result.append(": ");
        for (int i = 0; i < this.header.length(); i++) {
            if (i > 0) result.append(",");
            result.append("(");
            result.append(x[i]);
            result.append(",");
            result.append(y[i]);
            result.append(")");
        }
        results.add(result.toString());
        return results;
    }

    private void loadPuzzle(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            ArrayList<String> rows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            this.header = rows.remove(0);
            this.grid = new String[rows.size()];

            for (int i = 0; i < rows.size(); i++) {
                this.grid[i] = rows.get(i).replace(",","");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
