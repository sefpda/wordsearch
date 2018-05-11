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
        assertEquals("HI: (0,0),(1,0)", results.get(0));
    }

    @Test
    public void findsMultipleHorizontalMatchesInSmallGrid() {
        String file = "inputfiles/smallgrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("ROLL: (0,0),(1,0),(2,0),(3,0)", results.get(0));
        assertEquals("DICE: (0,3),(1,3),(2,3),(3,3)", results.get(1));
        assertEquals("CAP: (1,2),(2,2),(3,2)", results.get(2));
    }

}
