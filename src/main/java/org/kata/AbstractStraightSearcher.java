package org.kata;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStraightSearcher extends AbstractSearcher {

    protected List<Result> findCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        List<Result> results = new ArrayList<Result>();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(word)) {
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(word) + j;
                    y[j] = yStable ? i : source[i].indexOf(word) + j;
                }
                results.add(new Result(word, x, y));
                x = new int[source.length];
                y = new int[source.length];
            }
        }
        return results;
    }

    protected List<Result> findReverseCoordinatesAlongStraightLine(String[] source, String word, boolean xStable, boolean yStable) {
        int[] x = new int[source.length];
        int[] y = new int[source.length];
        List<Result> results = new ArrayList<Result>();
        String reversed = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains(reversed)) {
                for (int j = 0; j < word.length(); j++) {
                    x[j] = xStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                    y[j] = yStable ? i : source[i].indexOf(reversed) + reversed.length() - 1 - j;
                }
                results.add(new Result(word, x, y));
                x = new int[source.length];
                y = new int[source.length];
            }
        }
        return results;
    }
}
