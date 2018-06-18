package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownwardDiagonalSearcherTest {

    @Test
    public void findsOnLongestSlant_startingAtOrigin() {
        String[] rows = {
            "ROW",
            "SUN",
            "TON",
        };
        List<Result> result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "RUN");
        assertEquals("RUN: (0,0),(1,1),(2,2)", result.get(0).text());
    }

    @Test
    public void findsOnLongestSlant_startingPartway() {
        String[] rows = {
            "FORM",
            "ATEN",
            "ROOT",
            "COPM"
        };
        List<Result> result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TOM");
        assertEquals("TOM: (1,1),(2,2),(3,3)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_startingOnFirstRow() {
        String[] rows = {
            "TOL",
            "RUN",
            "AQB",
        };
        List<Result> result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (1,0),(2,1)", result.get(0).text());
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
        List<Result> result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TOR");
        assertEquals("TOR: (2,1),(3,2),(4,3)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_startingOnSide() {
        String[] rows = {
            "WUN",
            "TXP",
            "AOI"
        };
        List<Result> result = DownwardDiagonalSearcher.instance().findCoordinates(rows, "TO");
        assertEquals("TO: (0,1),(1,2)", result.get(0).text());
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
            "QOT",
            "ONH",
            "YHM"
        };
        List<Result> results = DownwardDiagonalSearcher.instance().findCoordinates(rows, "OH");
        assertEquals("OH: (1,0),(2,1)", results.get(0).text());
        assertEquals("OH: (0,1),(1,2)", results.get(1).text());
    }
}
