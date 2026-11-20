package com.husain.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Provides basic and extended calculator operations.
 * BigDecimal is used to avoid common floating-point precision issues.
 */
public class Calculator {

    private static final int DIVISION_SCALE = 10;

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }

    public BigDecimal divide(BigDecimal first, BigDecimal second) {
        if (second.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return first.divide(second, DIVISION_SCALE, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

    public BigDecimal modulus(BigDecimal first, BigDecimal second) {
        if (second.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Cannot calculate modulus with zero.");
        }
        return first.remainder(second);
    }

    public BigDecimal power(BigDecimal base, int exponent) {
        if (exponent < 0) {
            if (base.compareTo(BigDecimal.ZERO) == 0) {
                throw new ArithmeticException("Zero cannot be raised to a negative power.");
            }
            return BigDecimal.ONE.divide(
                    base.pow(Math.abs(exponent), MathContext.DECIMAL128),
                    MathContext.DECIMAL128
            );
        }
        return base.pow(exponent);
    }

    public BigDecimal squareRoot(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Square root of a negative number is not supported.");
        }
        return number.sqrt(MathContext.DECIMAL128);
    }

    public BigDecimal percentage(BigDecimal number, BigDecimal percent) {
        return number.multiply(percent)
                .divide(BigDecimal.valueOf(100), MathContext.DECIMAL128);
    }
}
