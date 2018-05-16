package org.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.nio.file.NoSuchFileException;
import java.util.List;

public class WordSearchTest {

    @Test
    public void findsSingleHorizontalMatchInTinyGrid() throws Exception {
        String file = "inputfiles/tinygrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("HI: (0,0),(1,0)", results.get(0));
    }

    @Test
    public void findsMultipleHorizontalMatchesInSmallGrid() throws Exception {
        String file = "inputfiles/smallgrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("ROLL: (0,0),(1,0),(2,0),(3,0)", results.get(0));
        assertEquals("DICE: (0,3),(1,3),(2,3),(3,3)", results.get(1));
        assertEquals("CAP: (1,2),(2,2),(3,2)", results.get(2));
    }

    @Test
    public void findsVerticalMatches() throws Exception {
        String file = "inputfiles/verticalgrid.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("JOHN: (2,2),(2,3),(2,4),(2,5)", results.get(0));
        assertEquals("RICK: (5,1),(5,2),(5,3),(5,4)", results.get(1));
        assertEquals("ANDREA: (4,0),(4,1),(4,2),(4,3),(4,4),(4,5)", results.get(2));
        assertEquals("EUGENE: (0,0),(0,1),(0,2),(0,3),(0,4),(0,5)", results.get(3));
    }

    @Test
    public void findsDownwardDiagonal() throws Exception {
        String file = "inputfiles/downdiagonal.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("WHEN: (0,0),(1,1),(2,2),(3,3)", results.get(0));
        assertEquals("MY: (0,3),(1,4)", results.get(1));
        assertEquals("NOW: (2,0),(3,1),(4,2)", results.get(2));
        assertEquals("HI: (1,3),(2,4)", results.get(3));
    }

    @Test
    public void findsUpwardDiagonal() throws Exception {
        String file = "inputfiles/updiagonal.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("CAT: (0,2),(1,1),(2,0)", results.get(0));
        assertEquals("APE: (1,3),(2,2),(3,1)", results.get(1));
        assertEquals("BIRD: (0,3),(1,2),(2,1),(3,0)", results.get(2));
    }

    @Test
    public void findsMixture_IncludingReverse() throws Exception {
        String file = "inputfiles/bigolmess.txt";
        WordSearch searcher = new WordSearch(file);
        List<String> results = searcher.getResults();
        assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)", results.get(0));
        assertEquals("KHAN: (5,9),(5,8),(5,7),(5,6)", results.get(1));
        assertEquals("KIRK: (4,7),(3,7),(2,7),(1,7)", results.get(2));
        assertEquals("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)", results.get(3));
        assertEquals("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)", results.get(4));
        assertEquals("SULU: (3,3),(2,2),(1,1),(0,0)", results.get(5));
        assertEquals("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)", results.get(6));
    }

    @Test
    public void rejectsNonExistantFile() {
        String file = "inputfiles/filenotfound.txt";
        WordSearch searcher = new WordSearch(file);
        Executable methodCall = () -> searcher.getResults();
        assertThrows(NoSuchFileException.class, methodCall);
    }

    @Test
    public void rejectsFileWithMalformedGrid() {
        String file = "inputfiles/notsquare.txt";
        WordSearch searcher = new WordSearch(file);
        Executable methodCall = () -> searcher.getResults();
        assertThrows(InvalidGridException.class, methodCall);
    }

    @Test
    public void rejectsFileWithNoSearchWords() {
        String file = "inputfiles/nowords.txt";
        WordSearch searcher = new WordSearch(file);
        Executable methodCall = () -> searcher.getResults();
        assertThrows(SearchWordFormatException.class, methodCall);
    }
}
