package org.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class WordSearchTest {

    @Test
    public void findsFirstLetterOfSingleHorizontalMatchInTinyGrid() {
        File input = new File("tinygrid.txt");
        WordSearch searcher = new WordSearch(input);
        List<String> results = searcher.getResults();
        assertEquals(1, results.size());
    }

}
