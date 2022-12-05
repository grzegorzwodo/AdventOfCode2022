package com.adventofcode.day2;

public enum Result {
    WIN("Z", 6),
    LOSS("X", 0),
    DRAW("Y", 3);

    private String symbol;
    private int score;

    Result(String symbol, int score) {
        this.score = score;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }
}
