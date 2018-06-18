package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseUpwardDiagonalSearcherTest {

    @Test
    public void findsAlongLongestSlant_startsOnBottomOfFirstColumn() throws Exception {
        String[] rows = {
                "NUB",
                "AOM",
                "TOP"
        };
        List<Result> result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "BOT");
        assertEquals("BOT: (2,0),(1,1),(0,2)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_inMidstOfGrid() throws Exception {
        String[] rows = {
                "NSFHOL",
                "NWOBUA",
                "VNOWFL",
                "PWNOMD",
                "NQREDC",
                "ZXWPOL"
        };
        List<Result> result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "FOR");
        assertEquals("FOR: (4,2),(3,3),(2,4)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_startsOnTopRow() throws Exception {
        String[] rows = {
                "ABDDE",
                "QOERT",
                "GCVBN",
                "IOPNJ",
                "UPJLN"
        };
        List<Result> result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "DOG");
        assertEquals("DOG: (2,0),(1,1),(0,2)", result.get(0).text());
    }

    @Test
    public void findsOnShortSlant_endsOnBottom() throws Exception {
        String[] rows = new String[] {
                "JOI",
                "WEO",
                "ANT"
        };
        List<Result> result = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "ON");
        assertEquals("ON: (2,1),(1,2)", result.get(0).text());
    }

    @Test
    public void findsMultipleMatches() throws Exception {
        String[] rows = new String[] {
                "MTI",
                "OPT",
                "NOQ"
        };
        List<Result> results = ReverseUpwardDiagonalSearcher.instance().findCoordinates(rows, "TO");
        assertEquals("TO: (2,1),(1,2)", results.get(0).text());
        assertEquals("TO: (1,0),(0,1)", results.get(1).text());
    }
}
