package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSearcherTest {

    @Test
    public void findsWordStartingOnOrigin() {
        String[] rows = {
            "WEZ",
            "UGM",
            "ROX"
        };
        String[] result = HorizontalSearcher.instance().findCoordinates(rows, "WE");
        assertEquals("WE: (0,0),(1,0)", result[0]);
    }

    @Test
    public void findsWordStartingInMiddle() {
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
    public void findsWordAtEndOfLastRow() {
        String[] rows = {
            "EWI",
            "RIV",
            "YUP"
        };
        String[] result = HorizontalSearcher.instance().findCoordinates(rows, "UP");
        assertEquals("UP: (1,2),(2,2)", result[0]);
    }
}
