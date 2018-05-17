package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVerticalSearcherTest {

    @Test
    public void findsWordEndingAtOrigin() {
        String columns[] = {
                "TAC",
                "LEE",
                "LWO"
        };
        String result = ReverseVerticalSearcher.instance().findCoordinates(columns, "CAT");
        assertEquals("CAT: (0,2),(0,1),(0,0)", result);
    }

    @Test
    public void findsWordInMidstOfGrid() {
        String columns[] = {
                "ABEAX",
                "UVIOP",
                "VJIXA",
                "YPATS",
                "CNRWZ"
        };
        String result = ReverseVerticalSearcher.instance().findCoordinates(columns, "TAP");
        assertEquals("TAP: (3,3),(3,2),(3,1)", result);
    }

    @Test
    public void findsWordAtBottomOfLastColumn() {
        String[] columns = {
                "RAC",
                "NAV",
                "BAC"
        };
        String result = ReverseVerticalSearcher.instance().findCoordinates(columns, "CAB");
        assertEquals("CAB: (2,2),(2,1),(2,0)", result);
    }
}
