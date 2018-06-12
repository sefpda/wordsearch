package org.kata;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractSearcher {

    protected String generateResult(String word, int[] x, int[] y, boolean foundWord) {
        if (!foundWord) return null;
        StringBuilder result = new StringBuilder(word);
        result.append(": ");
        for (int i = 0; i < word.length(); i++) {
            if (i > 0) result.append(",");
            result.append("(");
            result.append(x[i]);
            result.append(",");
            result.append(y[i]);
            result.append(")");
        }
        return result.toString();
    }

    protected String findCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        boolean foundWord = false;
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(word)) {
                foundWord = true;
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(word) + j;
                    y[j] = yStable ? i : source[i].indexOf(word) + j;
                }
                break;
            }
        }
        return generateResult(word, x, y, foundWord);
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

    protected String findReverseCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        boolean foundWord = false;
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        String reversed = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(reversed)) {
                foundWord = true;
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                    y[j] = yStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                }
                break;
            }
        }
        return generateResult(word, x, y, foundWord);
    }

    abstract String[] findCoordinates(String[] rows, String word);
}
