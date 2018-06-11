package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseHorizontalSearcherTest {

    @Test
    public void findsWordEndingAtOrigin() {
        String[] rows = {
                "NAF",
                "TOW",
                "MAT"
        };
        String[] result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "FAN");
        assertEquals("FAN: (2,0),(1,0),(0,0)", result[0]);
    }

    @Test
    public void findsWordInMidstOfGrid() {
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
    public void findsWordOnLastLine() {
        String[] rows = {
                "GOT",
                "MAN",
                "ZIH"
        };
        String[] result = ReverseHorizontalSearcher.instance().findCoordinates(rows, "HI");
        assertEquals("HI: (2,2),(1,2)", result[0]);
    }
}
