package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseDownwardDiagonalSearcherTest {

    @Test
    public void findAlongLongestSlant_endingAtOrigin() {
        String[] rows = {
                "PDQ",
                "BOT",
                "HOB"
        };
        String[] result = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "BOP");
        assertEquals("BOP: (2,2),(1,1),(0,0)", result[0]);
    }

    @Test
    public void findAlongShortSlant_inMidstOfGrid() {
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
    public void findAlongShortSlant_endingOnFirstColumn() {
        String[] rows = {
                "BOT",
                "YOR",
                "ABE"
        };
        String[] result = ReverseDownwardDiagonalSearcher.instance().findCoordinates(rows, "BY");
        assertEquals("BY: (1,2),(0,1)", result[0]);
    }
}
