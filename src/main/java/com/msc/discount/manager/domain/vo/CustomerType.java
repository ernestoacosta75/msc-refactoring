package com.msc.discount.manager.domain.vo;

public final class CustomerType {

    private int value;

    private CustomerType(int value) {
        this.value = getValidCustomerType(value);
    }

    public static CustomerType create(int value) {

        return new CustomerType(value);
    }

    private int getValidCustomerType(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("The customer type value must be bigger than zero.");
        }
        return value;
    }

    public int getValue() {
        return this.value;
    }
}
