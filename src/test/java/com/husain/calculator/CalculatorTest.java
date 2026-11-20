package com.husain.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addsNumbers() {
        assertDecimalEquals("15.5", calculator.add(new BigDecimal("10.5"), new BigDecimal("5")));
    }

    @Test
    void subtractsNumbers() {
        assertDecimalEquals("6", calculator.subtract(new BigDecimal("10"), new BigDecimal("4")));
    }

    @Test
    void multipliesDecimalsPrecisely() {
        assertDecimalEquals("10.08", calculator.multiply(new BigDecimal("2.4"), new BigDecimal("4.2")));
    }

    @Test
    void dividesNumbers() {
        assertDecimalEquals("2.5", calculator.divide(new BigDecimal("10"), new BigDecimal("4")));
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(new BigDecimal("10"), BigDecimal.ZERO));
    }

    @Test
    void calculatesModulus() {
        assertDecimalEquals("1", calculator.modulus(new BigDecimal("10"), new BigDecimal("3")));
    }

    @Test
    void calculatesPositivePower() {
        assertDecimalEquals("125", calculator.power(new BigDecimal("5"), 3));
    }

    @Test
    void calculatesNegativePower() {
        assertDecimalEquals("0.25", calculator.power(new BigDecimal("2"), -2));
    }

    @Test
    void calculatesSquareRoot() {
        assertDecimalEquals("4", calculator.squareRoot(new BigDecimal("16")));
    }

    @Test
    void squareRootOfNegativeNumberThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.squareRoot(new BigDecimal("-9")));
    }

    @Test
    void calculatesPercentage() {
        assertDecimalEquals("25", calculator.percentage(new BigDecimal("200"), new BigDecimal("12.5")));
    }

    private void assertDecimalEquals(String expected, BigDecimal actual) {
        assertEquals(0, new BigDecimal(expected).compareTo(actual));
    }
}
