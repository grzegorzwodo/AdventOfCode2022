package com.adventofcode.day2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);
        long myScore = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String symbol1 = line.split(" ")[0];
            String symbol2 = line.split(" ")[1];

            RPSEnum opponent = getBySymbol(symbol1);

            RPSEnum my = getBySymbol(convertSymbol(symbol2));

            Result r = getResult(opponent, my);
            myScore += my.getScore();
            myScore += r.getScore();
        }


        System.out.println(myScore);
        //8392
    }

    private static String convertSymbol(String symbol2) {
        return switch (symbol2) {
            case "X" -> "A";
            case "Y" -> "B";
            case "Z" -> "C";
            default -> "Unknown";
        };
    }

    //Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
    static Result getResult(RPSEnum opponent, RPSEnum my) throws IOException {
        if (opponent == RPSEnum.ROCK) {
            if (my == RPSEnum.ROCK) return Result.DRAW;
            if (my == RPSEnum.PAPER) return Result.WIN;
            if (my == RPSEnum.SCISSORS) return Result.LOSS;
        }
        if (opponent == RPSEnum.PAPER) {
            if (my == RPSEnum.ROCK) return Result.LOSS;
            if (my == RPSEnum.PAPER) return Result.DRAW;
            if (my == RPSEnum.SCISSORS) return Result.WIN;
        }
        if (opponent == RPSEnum.SCISSORS) {
            if (my == RPSEnum.ROCK) return Result.WIN;
            if (my == RPSEnum.PAPER) return Result.LOSS;
            if (my == RPSEnum.SCISSORS) return Result.DRAW;
        }
        throw new IOException("Error in logic: " + opponent + " -> " + my);
    }

    static RPSEnum getBySymbol(String symbol) {
        return Arrays.stream(RPSEnum.values()).filter(v -> v.getSymbol().equals(symbol)).findFirst().get();
    }

    static String inputDemo = """
        A Y
        B X
        C Z
        """;
    static String input = """
        C Y
        A Z
        B X
        C Y
        B Y
        C X
        C Y
        B X
        B X
        A Z
        C X
        B Y
        B X
        B X
        A Z
        B X
        C Y
        C Y
        C X
        B X
        B X
        C Y
        C Y
        A Z
        C Y
        A X
        B Y
        C Y
        A Z
        B X
        B X
        C Y
        A Y
        A Y
        C Y
        C Z
        C Y
        C X
        C X
        B X
        C Y
        A Y
        C Z
        B X
        C Y
        B Y
        C Y
        A Y
        B X
        B Y
        A X
        A Y
        B X
        B X
        B X
        A Z
        C Y
        B Y
        A X
        A Y
        C X
        C X
        C Y
        B Y
        C X
        B X
        C X
        A Z
        B Y
        C X
        C Y
        B X
        B X
        C Y
        B X
        C Y
        A Z
        B Y
        B X
        B X
        B X
        C Y
        C Y
        A Y
        C X
        C X
        A Y
        C Y
        B X
        A Y
        C X
        C Y
        C X
        C X
        B Z
        C Y
        B X
        C Y
        A Y
        B Y
        B Y
        B X
        A Y
        C Y
        B X
        B Y
        A Y
        B X
        C Y
        C Y
        B Y
        B Y
        C Z
        C Y
        C X
        B X
        C Y
        B X
        C Y
        A Y
        A Y
        A Z
        C Z
        A Y
        B Y
        B X
        C X
        C Y
        C X
        B X
        B X
        A Y
        A Y
        C Y
        C Y
        A Z
        B X
        B X
        B X
        B Y
        B X
        B X
        C Y
        C Y
        C Y
        C X
        B X
        C Y
        B X
        A Z
        C Y
        C X
        A Z
        A Y
        A X
        C Y
        B X
        A Z
        C Y
        A Z
        C Y
        B Y
        A Z
        A Y
        A X
        A Z
        A Z
        C Y
        B X
        C Y
        C Y
        A Z
        B X
        C Y
        B X
        C Y
        A Y
        B X
        A Z
        A Z
        C Y
        A Z
        B Y
        B X
        A Z
        B X
        B X
        B X
        B Y
        C Y
        C Y
        C X
        A Y
        C X
        B X
        C Z
        B Y
        C Y
        A Y
        C X
        C X
        B X
        B X
        B X
        A Y
        B Y
        B X
        B X
        C Y
        A Y
        B X
        B X
        A Z
        C Y
        C Y
        B Y
        B X
        A Y
        B X
        B X
        A Z
        C Y
        A Y
        B X
        A Z
        C Z
        A Z
        B X
        B X
        B Y
        A Z
        C X
        B X
        C Y
        B X
        C Y
        C X
        A Z
        B X
        A Z
        C Y
        B X
        C X
        A Y
        B Y
        C Y
        B X
        B X
        B X
        B Y
        B X
        A X
        C Y
        B Y
        B Y
        C Y
        C Y
        C Y
        A Y
        A Y
        A X
        A Z
        C Y
        A Y
        C X
        C Y
        B Y
        C Y
        C Y
        B X
        C Y
        B X
        C Y
        C Y
        B X
        B Y
        B Y
        B X
        B Y
        B X
        C Y
        C Y
        C X
        C Y
        C X
        C X
        B Y
        A X
        C Y
        A Y
        C Z
        B X
        C Y
        A Y
        A Y
        C Y
        C Y
        B X
        B X
        B Y
        B Y
        C Y
        C X
        A Z
        C Y
        C Y
        C Y
        B Z
        A Z
        B X
        B Y
        C Y
        C Y
        B X
        A Z
        A Z
        B X
        C X
        C Y
        A X
        C Y
        B Y
        B X
        B X
        C Y
        B Y
        A Y
        B X
        B X
        C Z
        B Y
        B X
        C Y
        C Y
        C Y
        B X
        B Y
        C X
        B Y
        C Y
        C Y
        C X
        B X
        C Y
        B X
        C Y
        B X
        A Z
        C Y
        A X
        A Z
        B Z
        B Y
        C Y
        B X
        C Y
        C X
        B X
        B X
        B Y
        A Y
        C Y
        B X
        A Z
        C Y
        B X
        B X
        B X
        C Z
        B Y
        A Y
        B X
        C X
        A Y
        B X
        B X
        B X
        C Y
        C Y
        B X
        C Y
        C Y
        B X
        B Y
        B Y
        C Y
        B Y
        B X
        C X
        A Z
        B Y
        B X
        C Z
        A Y
        B X
        C X
        B X
        B X
        C Z
        B Y
        A X
        C X
        C X
        B X
        C Y
        A Z
        B X
        B X
        B X
        B X
        A Y
        C Y
        B Y
        B X
        A X
        B X
        C X
        C X
        B X
        C Y
        B Z
        A Z
        B X
        B X
        C Y
        B Z
        B X
        A Y
        B X
        A Z
        B X
        C X
        B X
        C X
        B X
        B X
        C Z
        B X
        A Y
        B X
        C Z
        B X
        C Y
        B X
        B Y
        B X
        B X
        C X
        B Y
        B Y
        A Y
        C Y
        B X
        B X
        C Y
        C Y
        C Y
        B X
        A Z
        C Y
        C Y
        A Z
        B X
        A Y
        C X
        B X
        C Y
        A Y
        B Y
        B Y
        A Z
        B X
        B X
        C Y
        B X
        B Y
        B X
        B X
        B X
        C Y
        C Y
        C Y
        C X
        B X
        B X
        C X
        C X
        B X
        A Y
        C Y
        C Y
        C Y
        C Z
        B X
        B X
        A Y
        B X
        A Y
        C X
        B X
        B X
        C Y
        C Y
        C Y
        A Y
        A Y
        A Y
        B X
        C Y
        B Y
        B X
        A Z
        C Y
        B X
        A Y
        B Y
        B Y
        B Y
        B Y
        C X
        A Y
        B X
        A Y
        B X
        C X
        C Y
        B X
        A Z
        C Y
        C Y
        B Y
        B X
        B X
        A Z
        B Y
        B Y
        C Y
        B X
        C X
        C Y
        B X
        B Y
        B X
        B X
        C Y
        B X
        B Y
        B X
        C Y
        B X
        A Y
        B X
        C Z
        B X
        C Y
        C Y
        B X
        B X
        C Y
        C Y
        C Y
        C X
        B Y
        B X
        C X
        B X
        C Z
        B X
        C Y
        A Y
        B X
        A Z
        C Y
        A Y
        B X
        A Z
        C Y
        C Y
        B X
        C Y
        A Y
        B X
        C X
        B Y
        C Y
        B X
        C X
        B X
        B Y
        A Y
        A Y
        A Y
        B X
        B X
        B X
        B X
        B Y
        B X
        B X
        B X
        A Z
        C X
        C Y
        A Z
        C X
        B X
        C Y
        B Y
        C Y
        B X
        C Y
        C Y
        C Y
        C Y
        C Y
        C Z
        B X
        B X
        C Y
        B X
        A Y
        C Y
        C X
        B Y
        C Y
        C Y
        A Y
        A Y
        C Y
        B Y
        C X
        B X
        C Y
        C Y
        B X
        B X
        B X
        A Z
        B Y
        B Y
        A Y
        C X
        B Y
        C Y
        C X
        B X
        B X
        C X
        B X
        C Y
        C Y
        B Y
        C Y
        B X
        B X
        A Z
        B Y
        A Z
        A X
        B Z
        A Y
        C Y
        C Y
        C Y
        B X
        A Z
        A Y
        B Y
        C Y
        B Y
        B X
        B X
        A Y
        C X
        C Y
        B X
        A Y
        A Z
        B X
        B X
        C Y
        B Y
        C Y
        C Y
        B Y
        B Y
        B X
        A Y
        B X
        B X
        B X
        B X
        C Y
        B X
        B Y
        C X
        C Y
        A Y
        B Y
        A Y
        C Y
        C Y
        A Z
        B X
        C Y
        A Z
        A Y
        B X
        B X
        B X
        C Y
        B X
        C Y
        B Y
        B X
        B Y
        A Y
        B X
        C Y
        C Y
        B X
        B X
        C Y
        C Y
        C Y
        B Z
        C Y
        B X
        C Y
        B Y
        C Y
        C X
        B X
        A Y
        A X
        A Z
        A Z
        B Y
        C X
        B X
        B Y
        B X
        B X
        A Z
        B X
        A Y
        C Z
        C Y
        C Y
        C Y
        A Y
        C X
        C Y
        A Z
        C Y
        B X
        A Y
        A Z
        B X
        A Y
        C X
        A Z
        A Y
        B X
        B X
        C Y
        C Y
        C Z
        A Z
        B X
        A Y
        B X
        B X
        B X
        C Y
        A Z
        C Y
        B X
        B Y
        C X
        C Y
        A Z
        A Z
        C Y
        B Y
        C Y
        C Y
        C X
        C Y
        C Y
        B X
        C Y
        B X
        B Y
        C Y
        C Y
        C X
        A Z
        B X
        B X
        C X
        C Y
        C X
        C X
        B X
        B Y
        B Y
        C Z
        A Y
        A Z
        B X
        B X
        C Y
        C Y
        A Y
        C Y
        B Y
        C Y
        B X
        C Y
        B Y
        B X
        C Y
        C Y
        B X
        C Z
        A Y
        B X
        C Y
        A Z
        C X
        C Y
        A Y
        B X
        A Y
        C Y
        B X
        C Y
        B X
        A Y
        C Y
        B Y
        B X
        B X
        C Y
        A Z
        A Z
        C X
        A Y
        B X
        C Y
        B X
        C X
        C Y
        C Y
        C Y
        C Y
        C X
        B Y
        B X
        B X
        C Y
        B Y
        B Y
        B X
        B X
        B X
        B Y
        B X
        B X
        B X
        C Y
        A Y
        A Y
        B X
        C Y
        C Y
        A Y
        C Y
        B Y
        C X
        B X
        B X
        A Y
        C Y
        B X
        B X
        B Y
        C Y
        B X
        C X
        B Y
        A Y
        A Y
        C Y
        C Y
        C Y
        C Y
        C Y
        B X
        C Y
        B Y
        B X
        B Y
        C Y
        B X
        B X
        B X
        B Y
        B X
        B X
        B X
        C Y
        B Y
        C Y
        B X
        B X
        B Y
        C X
        C X
        C Y
        B Y
        B X
        A Z
        B X
        B X
        C X
        C Y
        C Y
        B X
        A Z
        C Z
        C Y
        C Y
        C Y
        C X
        B Y
        B X
        C Y
        C Y
        C Y
        B Y
        B Y
        C Y
        C Y
        B Y
        A Z
        C Y
        A Z
        B X
        C Y
        A Y
        B X
        C Y
        C Y
        B X
        A X
        B X
        B X
        C Y
        C Z
        C Y
        A Y
        C Y
        C Y
        B X
        B X
        B X
        B X
        A Z
        C Y
        C Y
        B Y
        B X
        C Y
        C Y
        C Y
        B X
        A Y
        B X
        C Y
        B X
        B X
        C Y
        C Y
        B Y
        B Y
        C Y
        B Y
        C Y
        A Y
        A Y
        A Y
        C Y
        C Z
        B X
        A X
        C Y
        A Y
        C Y
        A Y
        B X
        B X
        B X
        B X
        B X
        C Z
        B X
        C Y
        C Y
        B Y
        A Z
        A Z
        C Y
        B Y
        C Z
        A Z
        C X
        A Y
        C Y
        C Y
        B X
        C Y
        B Y
        B Y
        C Y
        A X
        C Y
        B X
        A Y
        C X
        B Z
        C X
        B X
        B Y
        A Z
        A X
        B Z
        C Y
        B X
        B Y
        C X
        A Y
        C Y
        C Z
        B Y
        B Y
        B X
        B X
        C Y
        B X
        B Y
        C Y
        C X
        C Z
        C Z
        C Z
        A Y
        B X
        C Y
        C Y
        B X
        A Y
        B X
        A Y
        C X
        C X
        B Y
        A Y
        C Y
        A Y
        C Y
        C Y
        B X
        B X
        A X
        B X
        A Y
        C Y
        C Y
        C X
        A Y
        B X
        B Y
        B X
        B X
        B Z
        B X
        A Y
        C Y
        B X
        B X
        A Y
        A Z
        C Y
        C Y
        A Z
        A Z
        B X
        B X
        C Y
        B X
        B X
        A Y
        A Z
        B Y
        B X
        C Y
        C Y
        B X
        B X
        C X
        C Y
        B X
        B X
        B X
        B X
        B X
        C Y
        C Y
        A Y
        B Y
        B X
        A Z
        C Y
        B Y
        A Z
        C Y
        C Y
        B X
        A Z
        C Y
        A Y
        C X
        B X
        B X
        B Y
        B X
        A Z
        C Y
        B X
        B X
        B X
        B X
        B X
        B X
        C Y
        B X
        B Y
        B Y
        B Y
        C Z
        C Y
        B Y
        A Y
        A Y
        B Z
        B Y
        B Y
        B X
        B Y
        B Y
        C X
        A Z
        C Y
        C Y
        C Y
        B X
        B Y
        B X
        C Y
        C Y
        C Y
        B Y
        A Y
        C Y
        B X
        B X
        C Y
        B Y
        C Y
        B X
        B X
        B Y
        A Y
        C X
        C Z
        B X
        A Y
        C Y
        B X
        C Y
        B X
        C Z
        C Y
        C Y
        C Y
        A Z
        C X
        C Y
        C Y
        A Z
        A Z
        B X
        A Y
        C Y
        C Y
        B X
        A Z
        B X
        C Y
        B Y
        B X
        B X
        C Y
        C Y
        B Y
        C X
        B Y
        C Y
        B Y
        C Y
        B X
        C Y
        B X
        B Y
        B Y
        C X
        C Y
        A Z
        C Y
        C Y
        C Y
        A X
        A Y
        B Y
        C X
        B X
        C Y
        B X
        A Y
        B X
        C Y
        C Y
        C Y
        A Y
        B Y
        B Y
        B X
        A Z
        A Z
        B Z
        C Y
        B Y
        C Y
        B X
        A Z
        C Z
        B X
        C Y
        C Y
        C X
        C Y
        C Y
        C Z
        C Y
        B Y
        B X
        B Y
        B Y
        B X
        A Z
        C Y
        B X
        B X
        B Y
        B Y
        B X
        C X
        C Y
        C X
        B X
        B Y
        B Y
        A Y
        C Y
        B X
        A Y
        C Y
        B X
        B X
        C Y
        C Y
        C X
        B X
        C Z
        B X
        C Y
        A Y
        C X
        B X
        C Y
        B X
        C X
        A Y
        A Y
        A Y
        C Y
        B X
        B X
        B X
        B Y
        A X
        C X
        B X
        C Y
        B X
        B X
        A Y
        B X
        B X
        B X
        B X
        B Y
        B Y
        B X
        C X
        A Z
        C Y
        C Y
        C Y
        B Y
        C Y
        C Y
        B X
        B Y
        C Y
        A Z
        C Y
        B X
        B X
        C Y
        A Z
        C Y
        A Y
        B X
        C Y
        B X
        B Y
        C Y
        C X
        B X
        B Y
        B X
        B X
        B X
        B X
        C Y
        C Y
        A Y
        C Y
        B Z
        A Y
        C Y
        C Y
        B X
        A Y
        C Z
        C Y
        B Y
        C Y
        C Y
        B Y
        C Y
        B X
        B X
        C Y
        B X
        B X
        B Y
        B X
        B X
        B Y
        C X
        C Y
        B X
        A Y
        C X
        B X
        B X
        A X
        B Y
        C Y
        C Y
        B X
        A X
        A Y
        B Y
        B Y
        C Z
        B Y
        B Y
        B X
        B X
        C Y
        A Y
        C Y
        A Y
        B X
        C X
        B Y
        C Y
        B Y
        B Y
        C Y
        A Y
        C Y
        B X
        A X
        C Y
        B X
        B X
        B X
        C Y
        C Y
        C Y
        A Z
        A Z
        C Y
        A Y
        C Y
        B X
        B X
        C X
        B Y
        A Y
        A Z
        A Y
        C X
        B X
        C Y
        B Y
        B X
        A Y
        C Y
        B X
        A Y
        B Y
        C Y
        B Y
        B X
        C Y
        C Y
        B Y
        B X
        C Y
        B Y
        C X
        C Y
        B X
        B X
        C Y
        C Y
        A Y
        C X
        B X
        B X
        B Y
        A Y
        B Y
        B X
        C Y
        C Y
        C X
        B Y
        C Z
        C Y
        C Y
        B Y
        C Z
        B X
        C Y
        A Y
        A Z
        B Y
        B X
        C X
        A Y
        B X
        C Z
        B Y
        C Y
        B X
        B X
        B Y
        C Y
        B Y
        C Y
        C X
        B Y
        B X
        C Z
        B X
        B X
        B X
        B X
        A X
        B X
        C Y
        C X
        B X
        A Y
        C Y
        A Z
        C Y
        C Y
        C Y
        A Z
        B X
        C Y
        A Y
        B X
        B X
        C Y
        A Z
        B X
        C Y
        A Y
        A Z
        C Y
        A Y
        B Y
        B Y
        C Y
        C Y
        C Y
        B X
        C Y
        C Y
        B X
        B X
        A Z
        C X
        C Z
        A Z
        C Y
        B X
        B Y
        B X
        B Y
        C Y
        B X
        B X
        B X
        B X
        B X
        B Y
        C X
        C Y
        C Y
        B X
        B X
        B X
        C Y
        C Y
        C Y
        C Y
        A X
        B X
        B X
        A X
        B Y
        C Y
        C Y
        B Z
        C Y
        C Y
        B X
        B X
        C X
        A Y
        B Y
        B X
        C X
        B X
        B Y
        B X
        C Y
        C Y
        C Y
        B X
        A Z
        B X
        A X
        B X
        A Y
        C Y
        A Y
        C X
        B X
        B Y
        B X
        B X
        C Y
        A Y
        B Y
        A Y
        C Y
        B Y
        B Y
        B X
        A Z
        B X
        B X
        B X
        C Z
        B X
        C Y
        B X
        B X
        C Y
        C X
        B X
        C Y
        B X
        C Y
        C Z
        A Y
        B X
        C Y
        B Y
        C Y
        C Y
        C Y
        B Y
        B Y
        C Y
        A Y
        A Z
        C Y
        C Y
        C Y
        B X
        A Y
        C Z
        B Y
        C Y
        C Y
        B X
        B Y
        A X
        B X
        B Y
        B X
        C Y
        B X
        B Y
        B X
        A Z
        A Z
        B X
        B X
        B X
        C Y
        B X
        C Y
        A Y
        C X
        C Y
        A Z
        A Y
        B X
        B X
        C Y
        B X
        B Y
        A Y
        B X
        B X
        C X
        C X
        B X
        B Y
        C Y
        B X
        B X
        C Y
        B X
        B X
        C X
        B Y
        A Y
        C Y
        B X
        B X
        B Y
        C Y
        A Z
        B X
        C Y
        C Y
        B X
        B X
        A Y
        C Y
        C Y
        B X
        A Y
        B X
        B X
        A Z
        C Y
        B X
        B X
        C Y
        B Y
        C Y
        B X
        A Z
        C Y
        C Y
        B Z
        A Z
        B Z
        B X
        A Z
        C Y
        B Y
        C X
        A Z
        C Y
        A Y
        B X
        C Y
        C Y
        B X
        C Y
        B X
        C Y
        C Y
        B X
        B X
        C Y
        B Y
        A Y
        B X
        C Y
        A Y
        C Y
        C Y
        B X
        C Y
        B X
        B X
        B X
        C Y
        B X
        B Y
        B Y
        A Y
        A Y
        A Z
        B X
        C Y
        B Y
        B X
        B X
        C Y
        B Y
        C Y
        C Y
        A Z
        C Y
        C Y
        B Y
        A Y
        B Y
        C X
        B X
        B X
        B X
        B X
        A Z
        B X
        C X
        A Y
        C Y
        B X
        C Z
        C Y
        B X
        C Y
        B X
        B X
        A Y
        C Z
        B X
        B X
        C Y
        A Z
        A Y
        C X
        B Y
        B Y
        B X
        A Y
        C Y
        B X
        B Y
        B Y
        C Y
        C X
        A Z
        B Y
        C Y
        B X
        C X
        C X
        B Y
        A Z
        B Z
        B X
        B X
        A Z
        B Y
        C Y
        C Y
        B X
        C Z
        C Y
        C Y
        A Y
        C Y
        B Y
        B X
        C Y
        C Y
        A Y
        A Z
        A Z
        B X
        C Y
        B X
        B X
        B X
        B X
        A Z
        B X
        A X
        C Z
        C Y
        B Y
        A Y
        B X
        B Y
        A Z
        C Y
        C Y
        B X
        C Y
        C Y
        C X
        C Y
        B X
        B X
        B X
        C Y
        B Y
        B Y
        C Y
        C Y
        B X
        B X
        B X
        B X
        A Y
        C Y
        B X
        C X
        A Z
        C Y
        B X
        B Y
        B Y
        B Y
        C Z
        B Y
        A Y
        C X
        A Z
        C Y
        C Y
        C X
        A Y
        B Y
        A Y
        B X
        C X
        B X
        C Y
        B Y
        B X
        C Y
        C Y
        B X
        B Y
        B X
        A Z
        A Z
        A Y
        B X
        B X
        B Y
        C X
        A X
        B X
        B Y
        C X
        C Z
        C Y
        A Y
        C Y
        B X
        A Z
        B X
        B X
        A Z
        C X
        A Z
        C Y
        C Y
        A Z
        A Y
        B X
        C Z
        B X
        A Y
        B Y
        A X
        B Y
        B Y
        B Y
        B X
        C Y
        B X
        C Y
        C X
        C X
        A Z
        C Y
        B X
        A Y
        C Y
        A Y
        B X
        C Y
        C Y
        B X
        C Y
        B X
        C Y
        A Y
        A Z
        C Y
        B Z
        C Y
        C Y
        B X
        C Y
        C Y
        C Y
        B X
        A Y
        A Z
        B X
        A X
        B Z
        C Y
        B Z
        C Y
        B Y
        B Y
        C Y
        C Y
        B X
        C Y
        A Z
        B Y
        C Y
        C X
        A Y
        A Y
        B X
        B X
        B X
        A Y
        C Y
        A Y
        B Y
        C Y
        A Y
        A Y
        C Y
        B X
        C Y
        B X
        C Y
        B X
        B X
        C Y
        C X
        A Z
        C Y
        C Y
        A Z
        C Y
        A Y
        A X
        A Z
        B Y
        C Y
        B X
        C Y
        C Y
        C Y
        C Y
        A X
        B X
        C Y
        B Y
        B X
        B X
        A Y
        A Z
        C X
        C Y
        C Z
        C Y
        B Y
        C Y
        B X
        B X
        A X
        B X
        B X
        A Y
        C Y
        B X
        A Z
        C Y
        C Y
        A Z
        C Y
        C X
        B X
        B X
        B X
        C Y
        B Z
        C Y
        B X
        C X
        B X
        C Y
        C Y
        A Y
        C Y
        C Y
        C Z
        A Z
        C Y
        C Y
        C Y
        B X
        C X
        B Z
        C Y
        B X
        B X
        B X
        C Y
        B Y
        B X
        B Y
        A Y
        B Y
        B X
        C X
        C Y
        A Z
        B Y
        C Y
        B X
        C Y
        C X
        B X
        B X
        A Y
        B Y
        B X
        A Y
        B X
        C Y
        C Y
        C Y
        A Z
        A X
        C Y
        C Y
        C Y
        A Z
        B X
        B X
        A Y
        C Y
        C X
        C Y
        B X
        B X
        A Y
        A Y
        B X
        B X
        C Y
        B X
        B X
        A Y
        A Z
        B X
        A Y
        C Y
        C Y
        C Y
        B X
        B X
        C X
        A Y
        C Y
        B Y
        A Y
        C Z
        B X
        C Y
        B Y
        B X
        C Z
        A Y
        C X
        C Y
        C Y
        B X
        C X
        B X
        A Y
        C X
        B Y
        A Y
        A Y
        B X
        C Y
        B X
        C Y
        B Y
        C Y
        C Y
        B X
        B X
        B X
        B X
        B X
        C Y
        A Y
        C Y
        A Z
        A Y
        B X
        C X
        B X
        B Y
        C Z
        B Y
        B X
        C Y
        A X
        C X
        C Y
        B X
        C X
        A Y
        C Z
        C Y
        B X
        A Z
        A Y
        C Y
        C Y
        C Y
        C X
        B X
        A Z
        B Y
        C Y
        C Y
        B X
        B Y
        C X
        C Y
        B X
        B X
        B Z
        C Y
        B X
        B X
        B Z
        B X
        C Y
        C Y
        C Y
        C Z
        C Y
        B Y
        A Z
        A Z
        B X
        B Y
        A Z
        B Y
        B X
        B X
        B Y
        C X
        C Y
        A Y
        C X
        C X
        B Y
        A X
        B Y
        B X
        C Y
        C Y
        B X
        C Y
        A X
        C X
        C X
        B X
        B X
        C X
        B Y
        B Y
        A Y
        B X
        B X
        B X
        C X
        B X
        A Y
        C Y
        B X
        A Z
        B Y
        A Y
        B X
        B X
        C Y
        B Y
        A Z
        B X
        B X
        C Y
        A Y
        A Y
        A Z
        C Y
        A Y
        B X
        A Y
        B X
        C Y
        C Y
        C Y
        B X
        B Y
        B X
        C Y
        A Z
        A Z
        B Y
        B Y
        C X
        C X
        C Y
        B X
        C Y
        B X
        C Y
        C Y
        A Y
        A Y
        A Z
        A Y
        B X
        B X
        B X
        B Y
        C Y
        C X
        C Y
        B X
        B Y
        C Y
        C X
        C Y
        B X
        A Z
        C Y
        C Y
        B X
        A Z
        B X
        A Z
        A X
        A X
        B X
        B X
        C Y
        C X
        B Y
        C Z
        B X
        C Y
        A Z
        B X
        A Y
        C X
        B Y
        C Y
        B Y
        C X
        C Y
        C Y
        B X
        B Y
        C Y
        C X
        C Y
        B Y
        B Y
        B X
        B Z
        C Y
        C Y
        B X
        C Y
        C Y
        C Y
        B Y
        B Y
        C Y
        C Y
        C X
        B Z
        C Y
        C Y
        C Y
        B Y
        C X
        B Y
        A Y
        B X
        B Y
        A Z
        C Y
        B X
        A X
        C X
        B X
        B X
        A Y
        A Y
        A Y
        A Y
        B X
        B X
        A Z
        A Z
        C Y
        B X
        A Z
        B X
        B X
        C Y
        A Y
        B X
        B X
        A Y
        B X
        A X
        C Y
        B X
        B X
        A Z
        C Y
        B Y
        C Y
        A Z
        B X
        C X
        B Y
        C X
        B X
        B X
        C X
        A Y
        B X
        B Y
        B X
        C Y
        B X
        A Y
        B X
        C Y
        B Z
        B X
        A Z
        B X
        A Z
        A Y
        B Z
        B Y
        B X
        B X
        B Z
        B X
        C Y
        B Y
        A Z
        C Y
        B X
        B Y
        A Y
        C Y
        C Y
        B X
        B X
        C Y
        B X
        C Y
        B X
        B X
        A Y
        C Y
        A Y
        A Y
        A Y
        C Y
        C Y
        A Z
        B X
        A Y
        C Y
        B X
        C X
        B Y
        C Z
        C Y
        B X
        C Y
        C Y
        B X
        B X
        B X
        C X
        C X
        B X
        C X
        C X
        C X
        A Z
        B Y
        B X
        B X
        B X
        C Y
        A Z
        B Y
        B X
        B X
        B Y
        A Z
        B X
        C Y
        C Y
        A Z
        C Y
        B X
        A Y
        C Y
        B X
        """;
}
