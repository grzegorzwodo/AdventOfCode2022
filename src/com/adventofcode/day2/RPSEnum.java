package com.adventofcode.day2;

public enum RPSEnum {

    ROCK("A", 1),
    PAPER("B", 2),
    SCISSORS("C", 3);

    private String symbol;
    private int score;

    RPSEnum(String symbol, int score) {
        this.symbol = symbol;
        this.score = score;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
