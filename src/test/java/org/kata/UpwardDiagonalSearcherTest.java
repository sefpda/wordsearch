package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpwardDiagonalSearcherTest {

    @Test
    public void findsOnLongestSlant_startsInCorner() throws Exception {
        String[] rows = {
            "TRY",
            "UOP",
            "TLM"
        };
        List<Result> result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "TOY");
        assertEquals("TOY: (0,2),(1,1),(2,0)", result.get(0).text());
    }

    @Test
    public void findsOnLongestSlant_startsPartway() throws Exception {
        String[] rows = {
            "URO",
            "WNB",
            "XUG"
        };
        List<Result> result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "NO");
        assertEquals("NO: (1,1),(2,0)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_startsOnEdge() throws Exception {
        String[] rows = {
             "QOR",
             "TMV",
             "PRT"
        };
        List<Result> result = UpwardDiagonalSearcher.instance().findCoordinates(rows, "TO");
        assertEquals("TO: (0,1),(1,0)", result.get(0).text());
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
              "TOP",
              "NGO",
              "TNQ"
        };
        List<Result> results = UpwardDiagonalSearcher.instance().findCoordinates(rows, "NO");
        assertEquals("NO: (1,2),(2,1)", results.get(0).text());
        assertEquals("NO: (0,1),(1,0)", results.get(1).text());
    }
}
