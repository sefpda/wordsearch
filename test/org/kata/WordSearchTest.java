package org.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class WordSearchTest {

    @Test
    public void findsSingleHorizontalMatchInTinyGrid() {
        String file = "inputfiles/tinygrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals(1, results.size());
        assertEquals("HI: (0,0),(1,0)", results.get(0));
    }

}
