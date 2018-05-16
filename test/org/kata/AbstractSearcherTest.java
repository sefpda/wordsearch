package org.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractSearcherTest {

    @Test
    public void generateResultHandlesUnfoundWord() {
        String result = new TestSearcher().generateResult("DOG", new int[0], new int[0]);
        assertEquals("DOG: not found in search grid", result);
    }

    private static class TestSearcher extends AbstractSearcher {}
}
