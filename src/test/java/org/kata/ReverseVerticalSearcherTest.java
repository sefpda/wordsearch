package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVerticalSearcherTest {

    @Test
    public void findsWordEndingAtOrigin() throws Exception {
        String columns[] = {
                "TAC",
                "LEE",
                "LWO"
        };
        List<Result> result = ReverseVerticalSearcher.instance().findCoordinates(columns, "CAT");
        assertEquals("CAT: (0,2),(0,1),(0,0)", result.get(0).text());
    }

    @Test
    public void findsWordInMidstOfGrid() throws Exception {
        String columns[] = {
                "ABEAX",
                "UVIOP",
                "VJIXA",
                "YPATS",
                "CNRWZ"
        };
        List<Result> result = ReverseVerticalSearcher.instance().findCoordinates(columns, "TAP");
        assertEquals("TAP: (3,3),(3,2),(3,1)", result.get(0).text());
    }

    @Test
    public void findsWordAtBottomOfLastColumn() throws Exception {
        String[] columns = {
                "RAC",
                "NAV",
                "BAC"
        };
        List<Result> result = ReverseVerticalSearcher.instance().findCoordinates(columns, "CAB");
        assertEquals("CAB: (2,2),(2,1),(2,0)", result.get(0).text());
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] columns = {
                "PUP",
                "OPU",
                "PUQ"
        };
        List<Result> results = ReverseVerticalSearcher.instance().findCoordinates(columns, "UP");
        assertEquals("UP: (0,1),(0,0)", results.get(0).text());
        assertEquals("UP: (1,2),(1,1)", results.get(1).text());
        assertEquals("UP: (2,1),(2,0)", results.get(2).text());
    }
}
