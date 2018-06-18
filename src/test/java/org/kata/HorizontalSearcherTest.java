package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSearcherTest {

    @Test
    public void findsWordStartingOnOrigin() throws Exception {
        String[] rows = {
            "WEZ",
            "UGM",
            "ROX"
        };
        List<Result> result = HorizontalSearcher.instance().findCoordinates(rows, "WE");
        assertEquals("WE: (0,0),(1,0)", result.get(0).text());
    }

    @Test
    public void findsWordStartingInMiddle() throws Exception {
        String[] rows = {
            "SOHEM",
            "RZNMQ",
            "TRUMY",
            "SZOPS",
            "QWERT"
        };
        List<Result> result = HorizontalSearcher.instance().findCoordinates(rows, "RUM");
        assertEquals("RUM: (1,2),(2,2),(3,2)", result.get(0).text());
    }

    @Test
    public void findsWordAtEndOfLastRow() throws Exception {
        String[] rows = {
            "EWI",
            "RIV",
            "YUP"
        };
        List<Result> result = HorizontalSearcher.instance().findCoordinates(rows, "UP");
        assertEquals("UP: (1,2),(2,2)", result.get(0).text());
    }

    @Test
    public void findsMultipleOccurances() throws Exception {
        String[] rows = {
            "ONE",
            "TON",
            "OON"
        };
        List<Result> results = HorizontalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (0,0),(1,0)", results.get(0).text());
        assertEquals("ON: (1,1),(2,1)", results.get(1).text());
        assertEquals("ON: (1,2),(2,2)", results.get(2).text());
    }
}
