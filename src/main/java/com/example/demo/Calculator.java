package com.example.demo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Calculator{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Square root function - √x");
            System.out.println("2. Factorial function - x!");
            System.out.println("3. Natural logarithm (base е) - ln(x)");
            System.out.println("4. Power function - x^b");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the value for square root: ");
                        double sqrtInput = getValidDoubleInput(scanner);
                        System.out.println("Result: " + calculateSquareRoot(sqrtInput));
                        break;

                    case 2:
                        System.out.print("Enter the value for factorial: ");
                        int factorialInput = getValidIntegerInput(scanner);
                        System.out.println("Result: " + calculateFactorial(factorialInput));
                        break;

                    case 3:
                        System.out.print("Enter the value for natural logarithm: ");
                        double lnInput = getValidDoubleInput(scanner);
                        System.out.println("Result: " + calculateNaturalLogarithm(lnInput));
                        break;

                    case 4:
                        System.out.print("Enter the base value: ");
                        double base = getValidDoubleInput(scanner);
                        System.out.print("Enter the exponent value: ");
                        double exponent = getValidDoubleInput(scanner);
                        System.out.println("Result: " + calculatePower(base, exponent));
                        break;

                    case 5:
                        System.out.println("Exiting the calculator. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    public static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextDouble();
    }

    public static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    static BigDecimal calculateSquareRoot(double input) {
        return new BigDecimal(Math.sqrt(input), MathContext.DECIMAL64);
    }

    static BigDecimal calculateFactorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    static BigDecimal calculateNaturalLogarithm(double input) {
        return new BigDecimal(Math.log(input), MathContext.DECIMAL64);
    }

    static BigDecimal calculatePower(double base, double exponent) {
        return new BigDecimal(Math.pow(base, exponent), MathContext.DECIMAL64);
    }
}
