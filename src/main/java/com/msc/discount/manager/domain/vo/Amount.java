package com.msc.discount.manager.domain.vo;

/**
 * Value Object used to represent the
 * amount that belongs to a customer.
 *
 * @@author Ernesto A. Rodriguez Acosta
 */
public final class Amount {

    private double value;

    private Amount(double value) {
        this.value = getValidAmount(value);
    }

    public static Amount create(double value) {
        return new Amount(value);
    }

    private double getValidAmount(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("The amount must be bigger than zero.");
        }
        return value;
    }

    public double getValue() {
        return this.value;
    }
}
