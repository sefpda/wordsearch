package org.kata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordSearch {

    private final String fileName;
    private String header;
    private String[] grid;

    public static void main(String[] args) {
        // write your code here
    }

    public WordSearch(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getResults() {
        loadPuzzle();

        int x = -1;
        int y = -1;
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i].contains(this.header)) {
                x = i;
                y = this.grid[i].indexOf(this.header);
                break;
            }
        }

        ArrayList<String> results = new ArrayList<>();
        results.add(this.header + ": (" + x + "," + y + ")");
        return results;
    }

    private void loadPuzzle() {
        try (Stream<String> stream = Files.lines(Paths.get(this.fileName))) {

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
