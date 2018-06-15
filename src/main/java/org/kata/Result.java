package org.kata;

public class Result {

    private final String word;
    private final int[] x;
    private final int[] y;

    Result(String word, int[] x, int[] y) {
        this.word = word;
        this.x = x;
        this.y = y;
    }

    String text() {
        StringBuilder r = new StringBuilder(this.word);
        r.append(": ");
        if (x.length > 0) {
            appendCoordinates(r);
        } else {
            r.append("not found in word grid");
        }
        return r.toString();
    }

    private void appendCoordinates(StringBuilder r) {
        for(int i = 0; i < x.length; i++) {
            if (i > 0) r.append(",");
            r.append("(");
            r.append(x[i]);
            r.append(",");
            r.append(y[i]);
            r.append(")");
        }
    }
}
