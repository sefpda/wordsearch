package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @Test
    public void producesTextDescription() throws Exception {
        String word = "FOO";
        int[] x = new int[] { 1, 2, 3 };
        int[] y = new int[] { 2, 2, 2 };
        Result result = new Result(word, x, y);
        assertEquals("FOO: (1,2),(2,2),(3,2)", result.text());
    }

    @Test
    public void handlesMissingResults() throws Exception {
        String word = "BAR";
        Result result = new Result(word, new int[0], new int[0]);
        assertEquals("BAR: not found in word grid", result.text());
    }

    @Test
    public void coordinatesConstrainedByWord() throws Exception {
        String word = "EYE";
        int[] x = new int[]{ 1, 1, 1, 1 };
        int[] y = new int[]{ 0, 1, 2, 3 };
        Result result = new Result(word, x, y);
        assertEquals("EYE: (1,0),(1,1),(1,2)", result.text());
    }
}
