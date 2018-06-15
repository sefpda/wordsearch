package org.kata;

public class Result {

    private final String word;
    private final int[] x;
    private final int[] y;

    public Result(String word, int[] x, int[] y) {
        this.word = word;
        this.x = x;
        this.y = y;
    }

    public String text() {
        StringBuilder r = new StringBuilder(this.word);
        r.append(": ");
        for(int i = 0; i < x.length; i++) {
            if (i > 0) r.append(",");
            r.append("(");
            r.append(x[i]);
            r.append(",");
            r.append(y[i]);
            r.append(")");
        }
        return r.toString();
    }
}
