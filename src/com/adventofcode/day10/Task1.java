package com.adventofcode.day10;

import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);

        int[] searchedCycles = {20, 60, 100, 140, 180, 220};
        int i = 0;
        InstructionList instructionList = new InstructionList();
        long sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");
            int currentCycle = instructionList.runCommand(command[0], command.length > 1 ? Integer.parseInt(command[1]) : 0);
            if (currentCycle >= searchedCycles[i]) {
                if (currentCycle > searchedCycles[i]) {
                    sum = sum + (searchedCycles[i] * (instructionList.getxVal() - 1));
                } else {
                    sum = sum + (searchedCycles[i] * instructionList.getxVal());
                }
                System.out.println("Cycle: " + currentCycle + " -> " + instructionList.getxVal());
                i++;
                if (i == searchedCycles.length) break;
            }
        }
        System.out.println("Sum: " + sum);

    }

    private static boolean check(int[] arr, int toCheckValue) {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }

        return test;
    }

    static String inputDemo = """
        addx 15
        addx -11
        addx 6
        addx -3
        addx 5
        addx -1
        addx -8
        addx 13
        addx 4
        noop
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx -35
        addx 1
        addx 24
        addx -19
        addx 1
        addx 16
        addx -11
        noop
        noop
        addx 21
        addx -15
        noop
        noop
        addx -3
        addx 9
        addx 1
        addx -3
        addx 8
        addx 1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx -36
        noop
        addx 1
        addx 7
        noop
        noop
        noop
        addx 2
        addx 6
        noop
        noop
        noop
        noop
        noop
        addx 1
        noop
        noop
        addx 7
        addx 1
        noop
        addx -13
        addx 13
        addx 7
        noop
        addx 1
        addx -33
        noop
        noop
        noop
        addx 2
        noop
        noop
        noop
        addx 8
        noop
        addx -1
        addx 2
        addx 1
        noop
        addx 17
        addx -9
        addx 1
        addx 1
        addx -3
        addx 11
        noop
        noop
        addx 1
        noop
        addx 1
        noop
        noop
        addx -13
        addx -19
        addx 1
        addx 3
        addx 26
        addx -30
        addx 12
        addx -1
        addx 3
        addx 1
        noop
        noop
        noop
        addx -9
        addx 18
        addx 1
        addx 2
        noop
        noop
        addx 9
        noop
        noop
        noop
        addx -1
        addx 2
        addx -37
        addx 1
        addx 3
        noop
        addx 15
        addx -21
        addx 22
        addx -6
        addx 1
        noop
        addx 2
        addx 1
        noop
        addx -10
        noop
        noop
        addx 20
        addx 1
        addx 2
        addx 2
        addx -6
        addx -11
        noop
        noop
        noop
        """;

    static String input = """
        noop
        noop
        addx 5
        addx 29
        addx -28
        addx 5
        addx -1
        noop
        noop
        addx 5
        addx 12
        addx -6
        noop
        addx 4
        addx -1
        addx 1
        addx 5
        addx -31
        addx 32
        addx 4
        addx 1
        noop
        addx -38
        addx 5
        addx 2
        addx 3
        addx -2
        addx 2
        noop
        addx 3
        addx 2
        addx 5
        addx 2
        addx 3
        noop
        addx 2
        addx 3
        noop
        addx 2
        addx -32
        addx 33
        addx -20
        addx 27
        addx -39
        addx 1
        noop
        addx 5
        addx 3
        noop
        addx 2
        addx 5
        noop
        noop
        addx -2
        addx 5
        addx 2
        addx -16
        addx 21
        addx -1
        addx 1
        noop
        addx 3
        addx 5
        addx -22
        addx 26
        addx -39
        noop
        addx 5
        addx -2
        addx 2
        addx 5
        addx 2
        addx 23
        noop
        addx -18
        addx 1
        noop
        noop
        addx 2
        noop
        noop
        addx 7
        addx 3
        noop
        addx 2
        addx -27
        addx 28
        addx 5
        addx -11
        addx -27
        noop
        noop
        addx 3
        addx 2
        addx 5
        addx 2
        addx 27
        addx -26
        addx 2
        addx 5
        addx 2
        addx 4
        addx -3
        addx 2
        addx 5
        addx 2
        addx 3
        addx -2
        addx 2
        noop
        addx -33
        noop
        noop
        noop
        noop
        addx 31
        addx -26
        addx 6
        noop
        noop
        addx -1
        noop
        addx 3
        addx 5
        addx 3
        noop
        addx -1
        addx 5
        addx 1
        addx -12
        addx 17
        addx -1
        addx 5
        noop
        noop
        addx 1
        noop
        noop""";
}
