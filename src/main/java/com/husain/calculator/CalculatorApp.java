package com.husain.calculator;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Console entry point for the Java Calculator.
 */
public class CalculatorApp {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Calculator CALCULATOR = new Calculator();

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("         JAVA CALCULATOR");
        System.out.println("=================================");

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = SCANNER.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> calculateBinary("Addition", CALCULATOR::add);
                    case "2" -> calculateBinary("Subtraction", CALCULATOR::subtract);
                    case "3" -> calculateBinary("Multiplication", CALCULATOR::multiply);
                    case "4" -> calculateBinary("Division", CALCULATOR::divide);
                    case "5" -> calculateBinary("Modulus", CALCULATOR::modulus);
                    case "6" -> calculatePower();
                    case "7" -> calculateSquareRoot();
                    case "8" -> calculatePercentage();
                    case "9" -> {
                        running = false;
                        System.out.println("Thank you for using Java Calculator!");
                    }
                    default -> System.out.println("Invalid option. Please choose 1 to 9.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            } catch (ArithmeticException exception) {
                System.out.println("Error: " + exception.getMessage());
            }

            System.out.println();
        }

        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");
        System.out.println("6. Power");
        System.out.println("7. Square Root");
        System.out.println("8. Percentage");
        System.out.println("9. Exit");
    }

    private static BigDecimal readNumber(String prompt) {
        System.out.print(prompt);
        return new BigDecimal(SCANNER.nextLine().trim());
    }

    private static void calculateBinary(
            String operation,
            BinaryOperation calculatorOperation
    ) {
        BigDecimal first = readNumber("Enter first number: ");
        BigDecimal second = readNumber("Enter second number: ");
        BigDecimal result = calculatorOperation.calculate(first, second);
        printResult(operation, result);
    }

    private static void calculatePower() {
        BigDecimal base = readNumber("Enter base: ");
        System.out.print("Enter integer exponent: ");
        int exponent = Integer.parseInt(SCANNER.nextLine().trim());
        printResult("Power", CALCULATOR.power(base, exponent));
    }

    private static void calculateSquareRoot() {
        BigDecimal number = readNumber("Enter number: ");
        printResult("Square Root", CALCULATOR.squareRoot(number));
    }

    private static void calculatePercentage() {
        BigDecimal number = readNumber("Enter number: ");
        BigDecimal percent = readNumber("Enter percentage: ");
        printResult("Percentage", CALCULATOR.percentage(number, percent));
    }

    private static void printResult(String operation, BigDecimal result) {
        System.out.println(operation + " Result: " + result.stripTrailingZeros().toPlainString());
    }

    @FunctionalInterface
    private interface BinaryOperation {
        BigDecimal calculate(BigDecimal first, BigDecimal second);
    }
}
