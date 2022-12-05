package com.adventofcode.day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    private static List<Stack<String>> initStacks() {
        List<Stack<String>> listOfStack = new ArrayList<>();
        Stack<String> stack1 = initStack("QSWCZVFT");
        Stack<String> stack2 = initStack("QRB");
        Stack<String> stack3 = initStack("BZTQPMS");
        Stack<String> stack4 = initStack("DVFRQH");
        Stack<String> stack5 = initStack("JGLDBSTP");
        Stack<String> stack6 = initStack("WRTZ");
        Stack<String> stack7 = initStack("HQMNSFRJ");
        Stack<String> stack8 = initStack("RNFHW");
        Stack<String> stack9 = initStack("JZTQPRB");

        listOfStack.add(stack1);
        listOfStack.add(stack2);
        listOfStack.add(stack3);
        listOfStack.add(stack4);
        listOfStack.add(stack5);
        listOfStack.add(stack6);
        listOfStack.add(stack7);
        listOfStack.add(stack8);
        listOfStack.add(stack9);

        return listOfStack;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(input);

        //init demo stack
//        List<Stack<String>> listOfStack = initDemoStack();

        List<Stack<String>> listOfStack = initStacks();

        printStacks(listOfStack);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            printStacks(listOfStack);
            int move = Integer.parseInt(line.split(" ")[1]);
            int from = Integer.parseInt(line.split(" ")[3]);
            int to = Integer.parseInt(line.split(" ")[5]);
            for (int i = 0; i < move; i++) {
                String pop = listOfStack.get(from - 1).pop();
                listOfStack.get(to - 1).push(pop);
            }
        }

        printStacks(listOfStack);
        //BZLVHBWQF
    }

    private static List<Stack<String>> initDemoStack() {
        List<Stack<String>> listOfStack = new ArrayList<>();
        Stack<String> stack1 = initStack("ZN");
        Stack<String> stack2 = initStack("MCD");
        Stack<String> stack3 = initStack("P");

        listOfStack.add(stack1);
        listOfStack.add(stack2);
        listOfStack.add(stack3);
        return listOfStack;
    }

    private static void printStacks(List<Stack<String>> listOfStack) {
        for (int i = 0; i < listOfStack.size(); i++) {
            System.out.println("[" + i + "] -> " + listOfStack.get(i).toString());
        }
    }

    private static Stack<String> initStack(String characters) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < characters.length(); i++) {
            stack.push(characters.charAt(i) + "");
        }
        return stack;
    }


    static String inputDemo = """
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2""";

    static String input = """
        move 3 from 8 to 2
        move 3 from 1 to 5
        move 3 from 1 to 4
        move 2 from 7 to 4
        move 3 from 7 to 4
        move 8 from 5 to 7
        move 2 from 1 to 8
        move 7 from 3 to 2
        move 1 from 5 to 2
        move 1 from 6 to 7
        move 2 from 5 to 9
        move 1 from 9 to 1
        move 3 from 9 to 6
        move 5 from 6 to 2
        move 10 from 7 to 2
        move 3 from 8 to 9
        move 7 from 9 to 2
        move 1 from 1 to 2
        move 1 from 9 to 6
        move 1 from 4 to 1
        move 1 from 8 to 2
        move 11 from 4 to 2
        move 1 from 7 to 9
        move 1 from 4 to 6
        move 1 from 9 to 7
        move 1 from 1 to 3
        move 1 from 7 to 5
        move 1 from 4 to 9
        move 1 from 5 to 2
        move 1 from 3 to 8
        move 1 from 6 to 9
        move 1 from 8 to 6
        move 11 from 2 to 1
        move 1 from 6 to 8
        move 7 from 2 to 1
        move 14 from 2 to 7
        move 1 from 6 to 3
        move 1 from 8 to 2
        move 1 from 3 to 9
        move 7 from 7 to 1
        move 1 from 6 to 5
        move 5 from 7 to 6
        move 4 from 2 to 8
        move 3 from 6 to 7
        move 3 from 7 to 8
        move 9 from 1 to 3
        move 8 from 3 to 7
        move 1 from 3 to 1
        move 2 from 2 to 3
        move 1 from 6 to 7
        move 2 from 1 to 7
        move 7 from 1 to 6
        move 1 from 3 to 5
        move 2 from 5 to 3
        move 7 from 6 to 3
        move 9 from 7 to 5
        move 1 from 9 to 1
        move 4 from 8 to 5
        move 7 from 1 to 5
        move 4 from 7 to 2
        move 1 from 7 to 8
        move 1 from 6 to 4
        move 10 from 5 to 3
        move 8 from 5 to 1
        move 2 from 8 to 3
        move 2 from 8 to 9
        move 8 from 2 to 7
        move 4 from 9 to 8
        move 13 from 3 to 7
        move 1 from 5 to 3
        move 6 from 3 to 9
        move 10 from 1 to 9
        move 1 from 3 to 4
        move 6 from 9 to 7
        move 1 from 5 to 8
        move 14 from 7 to 6
        move 14 from 6 to 1
        move 13 from 1 to 8
        move 1 from 1 to 2
        move 9 from 8 to 9
        move 6 from 8 to 5
        move 2 from 4 to 6
        move 1 from 8 to 1
        move 2 from 2 to 1
        move 2 from 8 to 6
        move 3 from 1 to 2
        move 3 from 3 to 9
        move 16 from 9 to 1
        move 3 from 2 to 4
        move 3 from 7 to 2
        move 6 from 5 to 4
        move 5 from 7 to 3
        move 4 from 6 to 1
        move 10 from 2 to 9
        move 13 from 9 to 1
        move 5 from 7 to 2
        move 2 from 4 to 6
        move 1 from 9 to 1
        move 2 from 9 to 5
        move 2 from 6 to 8
        move 2 from 5 to 3
        move 1 from 8 to 3
        move 31 from 1 to 7
        move 2 from 1 to 5
        move 12 from 7 to 3
        move 11 from 3 to 2
        move 1 from 8 to 4
        move 6 from 4 to 5
        move 1 from 3 to 4
        move 8 from 3 to 2
        move 5 from 5 to 6
        move 2 from 6 to 7
        move 4 from 7 to 3
        move 1 from 6 to 9
        move 13 from 7 to 6
        move 13 from 2 to 3
        move 1 from 4 to 8
        move 10 from 2 to 3
        move 3 from 7 to 3
        move 2 from 2 to 1
        move 1 from 8 to 2
        move 2 from 4 to 7
        move 1 from 9 to 2
        move 3 from 7 to 3
        move 1 from 5 to 1
        move 2 from 5 to 2
        move 15 from 6 to 7
        move 4 from 1 to 9
        move 22 from 3 to 9
        move 7 from 3 to 9
        move 4 from 3 to 8
        move 4 from 9 to 4
        move 3 from 2 to 4
        move 5 from 7 to 1
        move 7 from 4 to 7
        move 2 from 8 to 4
        move 1 from 4 to 8
        move 3 from 1 to 5
        move 2 from 1 to 4
        move 1 from 2 to 9
        move 2 from 5 to 7
        move 1 from 5 to 9
        move 3 from 8 to 6
        move 8 from 7 to 1
        move 6 from 7 to 1
        move 10 from 1 to 9
        move 3 from 6 to 2
        move 2 from 1 to 3
        move 2 from 3 to 6
        move 3 from 7 to 4
        move 2 from 7 to 1
        move 1 from 2 to 5
        move 13 from 9 to 5
        move 12 from 9 to 3
        move 6 from 5 to 3
        move 2 from 9 to 1
        move 11 from 9 to 3
        move 1 from 4 to 6
        move 2 from 5 to 3
        move 1 from 1 to 8
        move 24 from 3 to 5
        move 2 from 9 to 3
        move 2 from 2 to 4
        move 1 from 9 to 2
        move 2 from 6 to 8
        move 5 from 3 to 5
        move 2 from 8 to 9
        move 1 from 9 to 8
        move 4 from 1 to 4
        move 1 from 9 to 4
        move 1 from 8 to 4
        move 1 from 8 to 4
        move 7 from 4 to 5
        move 1 from 1 to 8
        move 1 from 6 to 5
        move 35 from 5 to 4
        move 18 from 4 to 3
        move 6 from 4 to 3
        move 8 from 5 to 8
        move 8 from 8 to 1
        move 2 from 4 to 9
        move 23 from 3 to 1
        move 1 from 8 to 5
        move 1 from 9 to 1
        move 1 from 5 to 1
        move 1 from 9 to 4
        move 11 from 1 to 2
        move 16 from 4 to 5
        move 3 from 3 to 5
        move 9 from 2 to 5
        move 1 from 4 to 1
        move 2 from 2 to 6
        move 1 from 2 to 9
        move 1 from 6 to 2
        move 1 from 3 to 5
        move 1 from 3 to 9
        move 1 from 2 to 9
        move 23 from 1 to 5
        move 1 from 6 to 9
        move 1 from 9 to 8
        move 27 from 5 to 1
        move 1 from 9 to 3
        move 18 from 5 to 8
        move 6 from 5 to 7
        move 1 from 5 to 6
        move 1 from 9 to 8
        move 12 from 8 to 3
        move 1 from 1 to 4
        move 6 from 7 to 8
        move 1 from 6 to 3
        move 1 from 4 to 2
        move 2 from 1 to 8
        move 1 from 2 to 9
        move 8 from 3 to 2
        move 2 from 9 to 7
        move 5 from 2 to 7
        move 7 from 7 to 2
        move 2 from 8 to 2
        move 3 from 1 to 9
        move 5 from 1 to 2
        move 3 from 9 to 8
        move 3 from 8 to 7
        move 5 from 2 to 5
        move 2 from 7 to 6
        move 12 from 8 to 9
        move 12 from 1 to 4
        move 9 from 9 to 3
        move 4 from 5 to 8
        move 12 from 3 to 8
        move 1 from 7 to 9
        move 3 from 9 to 2
        move 1 from 4 to 7
        move 3 from 1 to 7
        move 7 from 4 to 6
        move 3 from 6 to 2
        move 2 from 7 to 9
        move 18 from 8 to 1
        move 2 from 4 to 7
        move 1 from 2 to 8
        move 1 from 8 to 2
        move 10 from 2 to 3
        move 3 from 9 to 8
        move 2 from 6 to 7
        move 13 from 3 to 1
        move 2 from 8 to 9
        move 28 from 1 to 8
        move 1 from 5 to 2
        move 1 from 4 to 3
        move 4 from 7 to 6
        move 5 from 6 to 7
        move 7 from 2 to 6
        move 1 from 9 to 6
        move 2 from 2 to 4
        move 1 from 9 to 1
        move 4 from 1 to 2
        move 3 from 2 to 5
        move 3 from 4 to 9
        move 3 from 5 to 7
        move 1 from 1 to 4
        move 6 from 7 to 6
        move 1 from 2 to 6
        move 1 from 4 to 1
        move 1 from 1 to 8
        move 3 from 9 to 4
        move 18 from 6 to 3
        move 4 from 3 to 6
        move 1 from 7 to 9
        move 1 from 6 to 9
        move 2 from 3 to 6
        move 1 from 9 to 6
        move 1 from 9 to 2
        move 6 from 6 to 8
        move 3 from 4 to 7
        move 2 from 7 to 2
        move 35 from 8 to 7
        move 3 from 3 to 1
        move 26 from 7 to 2
        move 10 from 3 to 9
        move 6 from 9 to 4
        move 3 from 1 to 2
        move 1 from 4 to 3
        move 4 from 4 to 1
        move 1 from 3 to 6
        move 1 from 8 to 3
        move 1 from 6 to 2
        move 1 from 3 to 2
        move 13 from 7 to 3
        move 3 from 1 to 4
        move 4 from 3 to 1
        move 3 from 1 to 9
        move 2 from 1 to 9
        move 10 from 2 to 9
        move 19 from 2 to 9
        move 6 from 3 to 9
        move 2 from 3 to 4
        move 2 from 2 to 6
        move 17 from 9 to 8
        move 1 from 2 to 8
        move 2 from 9 to 3
        move 2 from 6 to 7
        move 8 from 9 to 3
        move 5 from 4 to 5
        move 14 from 9 to 4
        move 1 from 2 to 3
        move 1 from 7 to 2
        move 2 from 9 to 3
        move 1 from 2 to 7
        move 5 from 5 to 1
        move 1 from 2 to 1
        move 1 from 3 to 1
        move 1 from 9 to 7
        move 3 from 7 to 2
        move 3 from 3 to 7
        move 1 from 2 to 4
        move 1 from 3 to 8
        move 1 from 2 to 4
        move 4 from 3 to 4
        move 16 from 8 to 9
        move 3 from 1 to 4
        move 21 from 4 to 6
        move 1 from 7 to 2
        move 1 from 8 to 2
        move 1 from 1 to 3
        move 6 from 6 to 7
        move 3 from 1 to 9
        move 3 from 7 to 3
        move 1 from 4 to 6
        move 1 from 4 to 7
        move 2 from 2 to 6
        move 1 from 8 to 6
        move 13 from 6 to 7
        move 1 from 2 to 3
        move 15 from 9 to 8
        move 6 from 6 to 3
        move 13 from 8 to 3
        move 4 from 9 to 4
        move 5 from 4 to 8
        move 19 from 3 to 9
        move 3 from 3 to 1
        move 5 from 8 to 9
        move 17 from 9 to 7
        move 1 from 1 to 8
        move 4 from 9 to 6
        move 3 from 3 to 8
        move 1 from 1 to 2
        move 3 from 3 to 1
        move 36 from 7 to 6
        move 1 from 1 to 2
        move 7 from 8 to 2
        move 24 from 6 to 5
        move 2 from 6 to 7
        move 1 from 3 to 2
        move 4 from 6 to 8
        move 19 from 5 to 1
        move 8 from 6 to 4
        move 7 from 2 to 5
        move 3 from 2 to 8
        move 15 from 1 to 6
        move 2 from 9 to 5
        move 2 from 7 to 8
        move 3 from 4 to 1
        move 4 from 5 to 6
        move 1 from 9 to 7
        move 1 from 8 to 3
        move 3 from 6 to 1
        move 2 from 4 to 7
        move 13 from 1 to 8
        move 1 from 3 to 7
        move 1 from 4 to 5
        move 19 from 8 to 6
        move 1 from 7 to 3
        move 8 from 5 to 8
        move 1 from 6 to 8
        move 3 from 5 to 9
        move 1 from 6 to 4
        move 3 from 4 to 7
        move 1 from 3 to 9
        move 4 from 7 to 9
        move 20 from 6 to 3
        move 1 from 8 to 4
        move 2 from 9 to 4
        move 2 from 9 to 2
        move 2 from 9 to 3
        move 13 from 6 to 9
        move 9 from 9 to 8
        move 2 from 6 to 3
        move 8 from 8 to 2
        move 2 from 7 to 3
        move 5 from 9 to 3
        move 12 from 3 to 5
        move 1 from 4 to 7
        move 8 from 2 to 4
        move 8 from 4 to 7
        move 2 from 2 to 6
        move 2 from 8 to 9
        move 2 from 6 to 8
        move 2 from 9 to 6
        move 2 from 6 to 9
        move 2 from 4 to 8
        move 2 from 9 to 2
        move 6 from 3 to 1
        move 2 from 2 to 9
        move 3 from 9 to 3
        move 8 from 7 to 2
        move 6 from 1 to 2
        move 8 from 3 to 8
        move 1 from 7 to 3
        move 5 from 3 to 8
        move 6 from 2 to 7
        move 3 from 7 to 6
        move 2 from 7 to 9
        move 1 from 7 to 8
        move 8 from 5 to 7
        move 7 from 2 to 1
        move 7 from 1 to 6
        move 7 from 7 to 9
        move 1 from 7 to 6
        move 2 from 3 to 9
        move 2 from 8 to 5
        move 25 from 8 to 5
        move 5 from 5 to 1
        move 1 from 6 to 4
        move 17 from 5 to 4
        move 5 from 5 to 4
        move 23 from 4 to 7
        move 2 from 5 to 2
        move 4 from 6 to 3
        move 6 from 3 to 7
        move 1 from 5 to 2
        move 1 from 1 to 7
        move 2 from 2 to 8
        move 2 from 2 to 9
        move 1 from 5 to 7
        move 4 from 1 to 6
        move 2 from 8 to 3
        move 2 from 9 to 4
        move 1 from 4 to 8
        move 7 from 9 to 1
        move 2 from 3 to 5
        move 28 from 7 to 4
        move 4 from 6 to 2
        move 2 from 6 to 2
        move 3 from 7 to 4
        move 2 from 5 to 6
        move 4 from 2 to 6
        move 9 from 6 to 5
        move 4 from 1 to 7
        move 1 from 6 to 2
        move 3 from 2 to 3
        move 1 from 8 to 6
        move 1 from 7 to 4
        move 2 from 3 to 4
        move 1 from 7 to 4
        move 2 from 1 to 6
        move 1 from 7 to 9
        move 1 from 7 to 9
        move 1 from 6 to 2
        move 7 from 5 to 8
        move 1 from 3 to 9
        move 1 from 5 to 2
        move 7 from 8 to 7
        move 4 from 4 to 8
        move 2 from 8 to 4
        move 2 from 2 to 7
        move 1 from 1 to 7
        move 1 from 5 to 6
        move 32 from 4 to 7
        move 2 from 6 to 5
        move 2 from 8 to 2
        move 1 from 2 to 1
        move 2 from 5 to 4
        move 1 from 2 to 5
        move 1 from 1 to 4
        move 4 from 4 to 3
        move 1 from 6 to 4
        move 1 from 5 to 4
        move 5 from 9 to 1
        move 4 from 3 to 5
        move 3 from 1 to 6
        move 2 from 9 to 5
        move 2 from 1 to 3
        move 15 from 7 to 1
        move 5 from 5 to 3
        move 1 from 5 to 2
        move 3 from 4 to 5
        move 2 from 5 to 9
        move 3 from 3 to 6
        move 3 from 3 to 4
        move 1 from 3 to 8
        move 1 from 9 to 3
        move 2 from 4 to 9
        move 1 from 5 to 3
        move 2 from 9 to 6
        move 1 from 8 to 1
        move 1 from 3 to 2
        move 1 from 4 to 9
        move 2 from 9 to 3
        move 9 from 1 to 3
        move 5 from 3 to 4
        move 2 from 1 to 3
        move 4 from 1 to 5
        move 1 from 2 to 8
        move 3 from 4 to 9""";
}
