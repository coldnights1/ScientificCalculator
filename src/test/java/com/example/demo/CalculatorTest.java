package com.example.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void testCalculateSquareRoot() {
        assertEquals(new BigDecimal(Math.sqrt(25), MathContext.DECIMAL64), Calculator.calculateSquareRoot(25));
        assertEquals(new BigDecimal(Math.sqrt(9), MathContext.DECIMAL64), Calculator.calculateSquareRoot(9));
        assertEquals(new BigDecimal(Math.sqrt(0), MathContext.DECIMAL64), Calculator.calculateSquareRoot(0));
        assertThrows(ArithmeticException.class, () -> Calculator.calculateSquareRoot(-1));
    }

    @Test
    void testCalculateFactorial() {
        assertEquals(new BigDecimal(120), Calculator.calculateFactorial(5));
        assertEquals(new BigDecimal(1), Calculator.calculateFactorial(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculateFactorial(-1));
    }

    @Test
    void testCalculateNaturalLogarithm() {
        assertEquals(new BigDecimal(Math.log(10), MathContext.DECIMAL64), Calculator.calculateNaturalLogarithm(10));
        assertEquals(new BigDecimal(Math.log(2), MathContext.DECIMAL64), Calculator.calculateNaturalLogarithm(2));
        assertThrows(ArithmeticException.class, () -> Calculator.calculateNaturalLogarithm(-1));
    }

    @Test
    void testCalculatePower() {
        assertEquals(new BigDecimal(Math.pow(2, 3), MathContext.DECIMAL64), Calculator.calculatePower(2, 3));
        assertEquals(new BigDecimal(Math.pow(5, 0), MathContext.DECIMAL64), Calculator.calculatePower(5, 0));
        assertEquals(new BigDecimal(Math.pow(4, -2), MathContext.DECIMAL64), Calculator.calculatePower(4, -2));
        assertThrows(ArithmeticException.class, () -> Calculator.calculatePower(-1, 2.5));
    }

    @Test
    void testGetValidDoubleInput() {
        Scanner scanner = new Scanner("5.4");
        assertEquals(5.4, Calculator.getValidDoubleInput(scanner));
    }

    @Test
    void testGetValidIntegerInput() {
        Scanner scanner = new Scanner("42");
        assertEquals(42, Calculator.getValidIntegerInput(scanner));
    }
}

