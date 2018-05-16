package org.kata;

public abstract class AbstractSearcher {

    protected String generateResult(String word, int[] x, int[] y) {
        if (x.length == 0 || y.length == 0) return word + ": not found in search grid";
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
        return generateResult(word, x, y);
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
        return generateResult(word, x, y);
    }
}
