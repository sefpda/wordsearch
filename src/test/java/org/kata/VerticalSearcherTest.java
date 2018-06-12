package org.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VerticalSearcherTest {

    @Test
    public void findsWordStartingAtOrigin() throws Exception {
        String[] columns = {
            "HAT",
            "RBR",
            "OCN"
        };
        String[] result = VerticalSearcher.instance().findCoordinates(columns, "HAT");
        assertEquals("HAT: (0,0),(0,1),(0,2)", result[0]);
    }

    @Test
    public void findsWordStartingPartwayInFirstColumn() throws Exception {
        String[] columns = {
            "ACORN",
            "PARTY",
            "MOVIE",
            "MONTY",
            "MAPLE"
        };
        String[] result = VerticalSearcher.instance().findCoordinates(columns, "CORN");
        assertEquals("CORN: (0,1),(0,2),(0,3),(0,4)", result[0]);
    }

    @Test
    public void findsWordPartwaryInMiddleColumn() throws Exception {
        String[] columns = {
            "EWNB",
            "MUPZ",
            "QATL",
            "BMDS"
        };
        String[] result = VerticalSearcher.instance().findCoordinates(columns, "AT");
        assertEquals("AT: (2,1),(2,2)", result[0]);
    }

    @Test
    public void findsWordAtEndOfLastColumn() throws Exception {
        String[] columns = {
            "ZRE",
            "YPL",
            "DOH"
        };
        String[] result = VerticalSearcher.instance().findCoordinates(columns, "OH");
        assertEquals("OH: (2,1),(2,2)", result[0]);
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] columns = {
                "TOT",
                "ATO",
                "BPW"
        };
        String[] results = VerticalSearcher.instance().findCoordinates(columns, "TO");
        assertEquals("TO: (0,0),(0,1)", results[0]);
        assertEquals("TO: (1,1),(1,2)", results[1]);
    }
}
