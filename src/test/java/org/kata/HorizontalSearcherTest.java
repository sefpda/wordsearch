package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSearcherTest {

    @Test
    public void findsWordStartingOnOrigin() throws Exception {
        String[] rows = {
            "WEZ",
            "UGM",
            "ROX"
        };
        String[] result = HorizontalSearcher.instance().findCoordinates(rows, "WE");
        assertEquals("WE: (0,0),(1,0)", result[0]);
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
        String[] result = HorizontalSearcher.instance().findCoordinates(rows, "RUM");
        assertEquals("RUM: (1,2),(2,2),(3,2)", result[0]);
    }

    @Test
    public void findsWordAtEndOfLastRow() throws Exception {
        String[] rows = {
            "EWI",
            "RIV",
            "YUP"
        };
        String[] result = HorizontalSearcher.instance().findCoordinates(rows, "UP");
        assertEquals("UP: (1,2),(2,2)", result[0]);
    }

    @Test
    public void findsMultipleOccurances() throws Exception {
        String[] rows = {
            "ONE",
            "TON",
            "OON"
        };
        String[] results = HorizontalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (0,0),(1,0)", results[0]);
        assertEquals("ON: (1,1),(2,1)", results[1]);
        assertEquals("ON: (1,2),(2,2)", results[2]);
    }
}
