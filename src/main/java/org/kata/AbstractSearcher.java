package org.kata;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractSearcher {

    protected String generateResult(String word, int[] x, int[] y, boolean foundWord) {
        return new Result(word, x, y).text();
    }

    protected String[] findMultipleCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(word)) {
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(word) + j;
                    y[j] = yStable ? i : source[i].indexOf(word) + j;
                }
                results.add(generateResult(word, x, y, true));
            }
        }
        return results.toArray(new String[0]);
    }

    protected String[] findReverseCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        List<String> results = new ArrayList<String>();
        String reversed = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(reversed)) {
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                    y[j] = yStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                }
                results.add(generateResult(word, x, y, true));
            }
        }
        return results.toArray(new String[0]);
    }

    abstract String[] findCoordinates(String[] rows, String word);
}
