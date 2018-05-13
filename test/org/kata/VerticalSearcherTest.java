package org.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VerticalSearcherTest {

    @Test
    public void findsWordStartingAtOrigin() {
        String[] columns = {
            "HAT",
            "RBR",
            "OCN"
        };
        String result = VerticalSearcher.instance().findCoordinates(columns, "HAT");
        assertEquals("HAT: (0,0),(0,1),(0,2)", result);
    }

    @Test
    public void findsWordStartingPartwayInFirstColumn() {
        String[] columns = {
            "ACORN",
            "PARTY",
            "MOVIE",
            "MONTY",
            "MAPLE"
        };
        String result = VerticalSearcher.instance().findCoordinates(columns, "CORN");
        assertEquals("CORN: (0,1),(0,2),(0,3),(0,4)", result);
    }

    @Test
    public void findsWordPartwaryInMiddleColumn() {
        String[] columns = {
            "EWNB",
            "MUPZ",
            "QATL",
            "BMDS"
        };
        String result = VerticalSearcher.instance().findCoordinates(columns, "AT");
        assertEquals("AT: (2,1),(2,2)", result);
    }

    @Test
    public void findsWordAtEndOfLastColumn() {
        String[] columns = {
            "ZRE",
            "YPL",
            "DOH"
        };
        String result = VerticalSearcher.instance().findCoordinates(columns, "OH");
        assertEquals("OH: (2,1),(2,2)", result);
    }
}
