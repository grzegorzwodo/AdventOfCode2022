package com.adventofcode.day10;

import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.List;

public class InstructionList {
    private int cycles;
    private int xVal;
    private Range<Integer> sprite;
    private List<String> pixels;

    public int getCycles() {
        return cycles;
    }

    public int getxVal() {
        return xVal;
    }

    public InstructionList() {
        this.cycles = 1;
        this.xVal = 1;
        this.pixels = new ArrayList<>();
        this.sprite = Range.between(1, 3);
    }

    public int runCommand(String name, int value) {
        if (name.equals("noop")) {
            addPixel();
            cycles++;
        }
        if (name.equals("addx")) {
            addPixel();
            cycles++;
            addPixel();
            cycles++;
            xVal += value;
            sprite = Range.between(sprite.getMinimum() + value, sprite.getMaximum() + value);
        }
        return cycles;
    }

    private void addPixel() {
        if (sprite.contains(cycles % 40)) {
            pixels.add("#");
        } else {
            pixels.add(".");
        }
    }

    public void printPixels() {
        for (int i = 1; i <= pixels.size(); i++) {
            System.out.print(pixels.get(i - 1));
            if (i % 40 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
