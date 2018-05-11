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

    @Test
    public void findsVerticalMatches() {
        String file = "inputfiles/verticalgrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("JOHN: (2,2),(2,3),(2,4),(2,5)", results.get(0));
        assertEquals("RICK: (5,1),(5,2),(5,3),(5,4)", results.get(1));
        assertEquals("ANDREA: (4,0),(4,1),(4,2),(4,3),(4,4),(4,5)", results.get(2));
        assertEquals("EUGENE: (0,0),(0,1),(0,2),(0,3),(0,4),(0,5)", results.get(3));
    }

}
