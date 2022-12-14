package com.msc.discount.manager.domain.vo;
/**
 * Value Object used to represent the seniority of a client.
 *
 * @@author Ernesto A. Rodriguez Acosta
 */
public final class Seniority {

    private int value;

    private Seniority(int value) {
        this.value = getValidSeniority(value);
    }

    public static Seniority create(int value) {
        return new Seniority(value);
    }

    private int getValidSeniority(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("The seniority must be bigger than zero.");
        }
        return value;
    }

    public int getValue() {
        return this.value;
    }
}
