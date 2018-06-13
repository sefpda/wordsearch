package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseHorizontalSearcherTest {

    @Test
    public void findsWordEndingAtOrigin() throws Exception {
        String[] rows = {
                "NAF",
                "TOW",
                "MAT"
        };
        String[] result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "FAN");
        assertEquals("FAN: (2,0),(1,0),(0,0)", result[0]);
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
        String[] result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "TON");
        assertEquals("TON: (3,2),(2,2),(1,2)", result[0]);
    }

    @Test
    public void findsWordOnLastLine() throws Exception {
        String[] rows = {
                "GOT",
                "MAN",
                "ZIH"
        };
        String[] result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "HI");
        assertEquals("HI: (2,2),(1,2)", result[0]);
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = {
                "IPO",
                "UIP",
                "ERN"
        };
        String[] results = ReverseHorizontalSearcher.instance().findCoordinates(rows, "PI");
        assertEquals("PI: (1,0),(0,0)", results[0]);
        assertEquals("PI: (2,1),(1,1)", results[1]);

    }
}
