package com.adventofcode.day11;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);

        List<MonkeyV2> monkeys = new ArrayList<>();
        MonkeyV2 currentMonkey = new MonkeyV2(0);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("Monkey")) {
                Integer id = Integer.valueOf(line.split(" ")[1].substring(0, 1));
                currentMonkey = new MonkeyV2(id);
                continue;
            }
            if (line.startsWith("Starting items:")) {
                String items = line.split(":")[1];
                List<BigDecimal> itemList = Arrays.stream(items.split(",")).map(i -> BigDecimal.valueOf(Long.parseLong(i.trim())))
                    .collect(Collectors.toList());
                currentMonkey.setStartingItems(itemList);
                continue;
            }
            if (line.startsWith("Operation:")) {
                String operation = line.split("new = old")[1].trim();
                currentMonkey.setOperation(operation);
                continue;
            }
            if (line.startsWith("Test:")) {
                String divisibleBy = line.split("divisible by")[1].trim();
                currentMonkey.setDivisibleBy(Integer.valueOf(divisibleBy));
                continue;
            }
            if (line.startsWith("If true: throw to monkey")) {
                String ifTrue = line.split("throw to monkey")[1].trim();
                currentMonkey.setThrowIfTrue(Integer.valueOf(ifTrue));
                continue;
            }
            if (line.startsWith("If false: throw to monkey")) {
                String ifFalse = line.split("throw to monkey")[1].trim();
                currentMonkey.setThrowIfFalse(Integer.valueOf(ifFalse));
                continue;
            }
            monkeys.add(currentMonkey);
        }

        Integer result = monkeys.stream().map(m -> m.getDivisibleBy()).reduce(1, (a, b) -> a * b);
        for (int i = 0; i < 10_000; i++) {
            nextRound(monkeys, result);
        }
        List<Long> sortedInspectedCounters = monkeys.stream().map(m -> m.getInspectedCounter()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(sortedInspectedCounters);
        System.out.println("Result: " + (sortedInspectedCounters.get(0) * sortedInspectedCounters.get(1)));
        //14508081294

    }

    private static void nextRound(List<MonkeyV2> monkeys, Integer divideBy) {
        for (MonkeyV2 monkey : monkeys) {
            List<BigDecimal> worryLevels = monkey.getStartingItems();
            monkey.setStartingItems(new ArrayList<>());
            for (BigDecimal worryLevel : worryLevels) {
                monkey.inspect();
                BigDecimal newWorryLevel = calculateWorryLevel(monkey.getOperation(), worryLevel);
                BigDecimal base = BigDecimal.valueOf(monkey.getDivisibleBy());
                newWorryLevel = newWorryLevel.divideAndRemainder(BigDecimal.valueOf(divideBy))[1];
                if (isDivisible(newWorryLevel, base)) {
                    monkeys.get(monkey.getThrowIfTrue()).addStartingItems(newWorryLevel);
                } else {
                    monkeys.get(monkey.getThrowIfFalse()).addStartingItems(newWorryLevel);
                }
            }
        }
    }

    private static boolean isDivisible(BigDecimal newWorryLevel, BigDecimal base) {
        return newWorryLevel.divideAndRemainder(base)[1].equals(BigDecimal.ZERO);
    }

    public static BigDecimal calculateWorryLevel(String operation, BigDecimal oldWorryLevel) {
        String factor = operation.split(" ")[1];
        BigDecimal factorInt = BigDecimal.ZERO;
        if (factor.contains("old")) {
            factorInt = oldWorryLevel;
        } else {
            factorInt = BigDecimal.valueOf(Long.parseLong(factor));
        }
        if (operation.startsWith("+")) {
            return oldWorryLevel.add(factorInt);
        }
        if (operation.startsWith("*")) {
            return oldWorryLevel.multiply(factorInt);
        }
        return factorInt;
    }

    static String inputDemo = """
        Monkey 0:
          Starting items: 79, 98
          Operation: new = old * 19
          Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3
                
        Monkey 1:
          Starting items: 54, 65, 75, 74
          Operation: new = old + 6
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 0
                
        Monkey 2:
          Starting items: 79, 60, 97
          Operation: new = old * old
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 3
                
        Monkey 3:
          Starting items: 74
          Operation: new = old + 3
          Test: divisible by 17
            If true: throw to monkey 0
            If false: throw to monkey 1
            
        """;

    static String input = """
        Monkey 0:
          Starting items: 84, 72, 58, 51
          Operation: new = old * 3
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 7
               
        Monkey 1:
          Starting items: 88, 58, 58
          Operation: new = old + 8
          Test: divisible by 2
            If true: throw to monkey 7
            If false: throw to monkey 5
               
        Monkey 2:
          Starting items: 93, 82, 71, 77, 83, 53, 71, 89
          Operation: new = old * old
          Test: divisible by 7
            If true: throw to monkey 3
            If false: throw to monkey 4
               
        Monkey 3:
          Starting items: 81, 68, 65, 81, 73, 77, 96
          Operation: new = old + 2
          Test: divisible by 17
            If true: throw to monkey 4
            If false: throw to monkey 6
               
        Monkey 4:
          Starting items: 75, 80, 50, 73, 88
          Operation: new = old + 3
          Test: divisible by 5
            If true: throw to monkey 6
            If false: throw to monkey 0
               
        Monkey 5:
          Starting items: 59, 72, 99, 87, 91, 81
          Operation: new = old * 17
          Test: divisible by 11
            If true: throw to monkey 2
            If false: throw to monkey 3
               
        Monkey 6:
          Starting items: 86, 69
          Operation: new = old + 6
          Test: divisible by 3
            If true: throw to monkey 1
            If false: throw to monkey 0
               
        Monkey 7:
          Starting items: 91
          Operation: new = old + 1
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 5
             
             """;
}
