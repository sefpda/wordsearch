package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseDownwardDiagonalSearcherTest {

    @Test
    public void findAlongLongestSlant_endingAtOrigin() throws Exception {
        String[] rows = {
                "PDQ",
                "BOT",
                "HOB"
        };
        String[] result = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "BOP");
        assertEquals("BOP: (2,2),(1,1),(0,0)", result[0]);
    }

    @Test
    public void findAlongShortSlant_inMidstOfGrid() throws Exception {
        String[] rows = {
                "TNIDAY",
                "HORNBP",
                "SONOQM",
                "NOMWTE",
                "NCPORW",
                "ZCUMSA"
        };
        String[] result = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "TOR");
        assertEquals("TOR: (4,3),(3,2),(2,1)", result[0]);
    }

    @Test
    public void findAlongShortSlant_endingOnFirstColumn() throws Exception {
        String[] rows = {
                "BOT",
                "YOR",
                "ABE"
        };
        String[] result = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "BY");
        assertEquals("BY: (1,2),(0,1)", result[0]);
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
                "OQT",
                "OSP",
                "RSS"
        };
        String[] results = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "SO");
        assertEquals("SO: (1,1),(0,0)", results[0]);
        assertEquals("SO: (1,2),(0,1)", results[1]);
    }
}
