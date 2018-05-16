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

    public WordSearch(String fileName) { this.fileName = fileName; }

    public List<String> getResults() throws IOException {
        loadPuzzle(fileName);

        List<String> results = new ArrayList<>();

        for (String word: this.words) {
            results.add(coordinates(word));
        }

        return results;
    }

    private String coordinates(String word) {
        String horizontalResult = HorizontalSearcher.instance().findCoordinates(this.rows, word);
        if (horizontalResult != null) return horizontalResult;
        String verticalResult = VerticalSearcher.instance().findCoordinates(this.columns, word);
        if (verticalResult != null) return verticalResult;
        String downDiagonal = DownwardDiagonalSearcher.instance().findCoordinates(this.rows, word);
        if (downDiagonal != null) return downDiagonal;
        String upDiagonal = UpwardDiagonalSearcher.instance().findCoordinates(this.rows, word);
        if (upDiagonal != null) return upDiagonal;
        String reverseVertical = ReverseVerticalSearcher.instance().findCoordinates(this.columns, word);
        if (reverseVertical != null) return reverseVertical;
        String reverseHorizontal = ReverseHorizontalSearcher.instance().findCoordinates(this.rows, word);
        if (reverseHorizontal != null) return reverseHorizontal;
        String reverseDownward = ReverseDownwardDiagonalSearcher.instance().findCoordinates(this.rows, word);
        if (reverseDownward != null) return reverseDownward;
        return ReverseUpwardDiagonalSearcher.instance().findCoordinates(this.rows, word);
    }

    private void loadPuzzle(String fileName) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileName));

        List<String> inputRows = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        String header = inputRows.remove(0);
        this.words = header.split(",");
        for (String word: words) {
            if (word.length() < 2) throw new SearchWordFormatException();
        }

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
