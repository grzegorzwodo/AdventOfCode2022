package com.adventofcode.day11;

import java.math.BigDecimal;
import java.util.List;

public class MonkeyV2 {
    private Integer id;
    private List<BigDecimal> startingItems;
    private String operation;
    private Integer divisibleBy;
    private Integer throwIfTrue;
    private Integer throwIfFalse;

    private long inspectedCounter;

    public MonkeyV2(Integer id) {
        this.id = id;
        this.inspectedCounter = 0;

    }

    public long getInspectedCounter() {
        return inspectedCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BigDecimal> getStartingItems() {
        return startingItems;
    }

    public void addStartingItems(BigDecimal item) {
        startingItems.add(item);
    }

    public void inspect() {
        this.inspectedCounter++;
    }

    public void setStartingItems(List<BigDecimal> startingItems) {
        this.startingItems = startingItems;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getDivisibleBy() {
        return divisibleBy;
    }

    public void setDivisibleBy(Integer divisibleBy) {
        this.divisibleBy = divisibleBy;
    }

    public Integer getThrowIfTrue() {
        return throwIfTrue;
    }

    public void setThrowIfTrue(Integer throwIfTrue) {
        this.throwIfTrue = throwIfTrue;
    }

    public Integer getThrowIfFalse() {
        return throwIfFalse;
    }

    public void setThrowIfFalse(Integer throwIfFalse) {
        this.throwIfFalse = throwIfFalse;
    }

    /**
     * Monkey 0:
     * Starting items: 84, 72, 58, 51
     * Operation: new = old * 3
     * Test: divisible by 13
     * If true: throw to monkey 1
     * If false: throw to monkey 7
     */
    @Override
    public String toString() {
        return "Monkey " + id + ": \n" +
            "  Starting items:" + startingItems + "\n" +
            "  Operation: new = old " + operation + "\n" +
            "  Test: divisible by " + divisibleBy + "\n" +
            "    If true: throw to monkey " + throwIfTrue + "\n" +
            "    If false: throw to monkey " + throwIfFalse + "\n" +
            "  Inspected: " + inspectedCounter + "\n";
    }


}
