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
}
