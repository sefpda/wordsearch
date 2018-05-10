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

    public static void main(String[] args) {
        // write your code here
    }

    public WordSearch(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getResults() {
        loadPuzzle();
        ArrayList<String> results = new ArrayList<>();
        results.add("HI: (0,0)");
        return results;
    }

    private void loadPuzzle() {
        try (Stream<String> stream = Files.lines(Paths.get(this.fileName))) {

            ArrayList<String> rows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            this.header = rows.remove(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
