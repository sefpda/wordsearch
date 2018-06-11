package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownwardDiagonalSearcherTest {

    @Test
    public void findsOnLongestSlant_startingAtOrigin() {
        String[] rows = {
            "ROW",
            "SUN",
            "TON",
        };
        String[] result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "RUN");
        assertEquals("RUN: (0,0),(1,1),(2,2)", result[0]);
    }

    @Test
    public void findsOnLongestSlant_startingPartway() {
        String[] rows = {
            "FORM",
            "ATEN",
            "ROOT",
            "COPM"
        };
        String[] result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TOM");
        assertEquals("TOM: (1,1),(2,2),(3,3)", result[0]);
    }

    @Test
    public void findsOnShortSlant_startingOnFirstRow() {
        String[] rows = {
            "TOL",
            "RUN",
            "AQB",
        };
        String[] result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (1,0),(2,1)", result[0]);
    }

    @Test
    public void findsOnShortSlant_startingPartway() {
        String[] rows = {
            "TWLLS",
            "EKTNP",
            "AOXOB",
            "NVPTR",
            "YPIJZ"
        };
        String[] result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TOR");
        assertEquals("TOR: (2,1),(3,2),(4,3)", result[0]);
    }

    @Test
    public void findsOnShortSlant_startingOnSide() {
        String[] rows = {
            "WUN",
            "TXP",
            "AOI"
        };
        String[] result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TO");
        assertEquals("TO: (0,1),(1,2)", result[0]);
    }
}
