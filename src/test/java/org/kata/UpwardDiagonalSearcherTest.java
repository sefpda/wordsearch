package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpwardDiagonalSearcherTest {

    @Test
    public void findsOnLongestSlant_startsInCorner() throws Exception {
        String[] rows = {
            "TRY",
            "UOP",
            "TLM"
        };
        String[] result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "TOY");
        assertEquals("TOY: (0,2),(1,1),(2,0)", result[0]);
    }

    @Test
    public void findsOnLongestSlant_startsPartway() throws Exception {
        String[] rows = {
            "URO",
            "WNB",
            "XUG"
        };
        String[] result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "NO");
        assertEquals("NO: (1,1),(2,0)", result[0]);
    }

    @Test
    public void findsOnShortSlant_startsOnEdge() throws Exception {
        String[] rows = {
             "QOR",
             "TMV",
             "PRT"
        };
        String[] result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "TO");
        assertEquals("TO: (0,1),(1,0)", result[0]);
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
              "TOP",
              "NGO",
              "TNQ"
        };
        String[] results = UpwardDiagonalSearcher.instance().findCoordinates(rows, "NO");
        assertEquals("NO: (1,2),(2,1)", results[0]);
        assertEquals("NO: (0,1),(1,0)", results[1]);
    }
}
