package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseUpwardDiagonalSearcherTest {

    @Test
    public void findsAlongLongestSlant_startsOnBottomOfFirstColumn() {
        String[] rows = {
                "NUB",
                "AOM",
                "TOP"
        };
        String[] result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "BOT");
        assertEquals("BOT: (2,0),(1,1),(0,2)", result[0]);
    }

    @Test
    public void findsOnShortSlant_inMidstOfGrid() {
        String[] rows = {
                "NSFHOL",
                "NWOBUA",
                "VNOWFL",
                "PWNOMD",
                "NQREDC",
                "ZXWPOL"
        };
        String[] result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "FOR");
        assertEquals("FOR: (4,2),(3,3),(2,4)", result[0]);
    }

    @Test
    public void findsOnShortSlant_startsOnTopRow() {
        String[] rows = {
                "ABDDE",
                "QOERT",
                "GCVBN",
                "IOPNJ",
                "UPJLN"
        };
        String[] result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "DOG");
        assertEquals("DOG: (2,0),(1,1),(0,2)", result[0]);
    }

    @Test
    public void findsOnShortSlant_endsOnBottom() {
        String[] rows = new String[] {
                "JOI",
                "WEO",
                "ANT"
        };
        String[] result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (2,1),(1,2)", result[0]);
    }
}
