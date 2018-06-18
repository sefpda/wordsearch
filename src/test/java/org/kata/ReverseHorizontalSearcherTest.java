package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseHorizontalSearcherTest {

    @Test
    public void findsWordEndingAtOrigin() throws Exception {
        String[] rows = {
                "NAF",
                "TOW",
                "MAT"
        };
        List<Result> result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "FAN");
        assertEquals("FAN: (2,0),(1,0),(0,0)", result.get(0).text());
    }

    @Test
    public void findsWordInMidstOfGrid() throws Exception {
        String[] rows = {
                "SYPBX",
                "QWERV",
                "MNOTE",
                "PLBOQ",
                "ZBGEN"
        };
        List<Result> result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "TON");
        assertEquals("TON: (3,2),(2,2),(1,2)", result.get(0).text());
    }

    @Test
    public void findsWordOnLastLine() throws Exception {
        String[] rows = {
                "GOT",
                "MAN",
                "ZIH"
        };
        List<Result> result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "HI");
        assertEquals("HI: (2,2),(1,2)", result.get(0).text());
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
                "IPO",
                "UIP",
                "ERN"
        };
        List<Result> results = ReverseHorizontalSearcher.instance().findCoordinates(rows, "PI");
        assertEquals("PI: (1,0),(0,0)", results.get(0).text());
        assertEquals("PI: (2,1),(1,1)", results.get(1).text());

    }
}
