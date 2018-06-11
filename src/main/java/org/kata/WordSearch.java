package org.kata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordSearch {

    private final String fileName;
    private String[] words;
    private String[] rows;
    private String[] columns;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("WordSearch requires the path of the file to process");
            return;
        }
        String fileName = args[0];
        try {
            List<String> results = new WordSearch(fileName).getResults();
            for (String result : results) {
                System.out.println(result);
            }
        } catch (IOException ioe) {
            System.out.println("Could not process file '" + fileName);
        }
    }

    WordSearch(String fileName) { this.fileName = fileName; }

    List<String> getResults() throws IOException {
        loadPuzzle(this.fileName);
        List<String> results = new ArrayList<>();

        for (String word: this.words) {
            String result = coordinates(word);
            if (result == null) {
                results.add(word + ": not found in word grid");
            } else {
                results.add(result);
            }
        }

        return results;
    }

    private String coordinates(String word) {
        List<String> results = new ArrayList<String>();
        addResults(results, HorizontalSearcher.instance(), this.rows, word);
        addResults(results, VerticalSearcher.instance(), this.columns, word);
        addResults(results, DownwardDiagonalSearcher.instance(), this.rows, word);
        addResults(results, UpwardDiagonalSearcher.instance(), this.rows, word);
        addResults(results, ReverseVerticalSearcher.instance(), this.columns, word);
        addResults(results, ReverseHorizontalSearcher.instance(), this.rows, word);
        addResults(results, ReverseDownwardDiagonalSearcher.instance(), this.rows, word);
        addResults(results, ReverseUpwardDiagonalSearcher.instance(), this.rows, word);
        return results.isEmpty() ? null : results.get(0);
    }

    private void addResults(List<String> allResults, AbstractSearcher searcher, String[] grid, String word) {
        String[] currentSearchResult = searcher.findCoordinates(grid, word);
        if (currentSearchResult != null) {
            for (String result :
                    currentSearchResult) {
                if (result != null) allResults.add(result);
            }
        }
    }

    private void loadPuzzle(String fileName) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileName));

        List<String> inputRows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        String header = inputRows.remove(0);
        this.words = header.split(",");
        for (String word: words) {
            if (word.length() < 2) throw new SearchWordFormatException();
        }

        if (inputRows.size() < 2) throw new InvalidGridException(0);

        this.rows = new String[inputRows.size()];
        this.columns = new String[inputRows.size()];

        for (int i = 0; i < inputRows.size(); i++) {
            this.rows[i] = inputRows.get(i).replace(",","");
            if (rows[i].length() != inputRows.size()) throw new InvalidGridException(inputRows.size());
        }
        for (int i = 0; i < inputRows.size(); i++) {
            char[] column = new char[this.rows.length];

            for (int j = 0; j < this.rows.length; j++) {
                column[j] = this.rows[j].charAt(i);
            }
            this.columns[i] = new String(column);
        }
    }
}
