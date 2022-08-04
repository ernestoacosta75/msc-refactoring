package com.msc.discount.manager.infrastructure.impl;

import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.Seniority;

public class DiscountCalculatorUtils {

    public static final int UNREGISTERED_SENIORITY_LEVEL = 1;
    public static final int REGISTERED_SENIORITY_LEVEL = 2;
    public static final int VALUABLE_SENIORITY_LEVEL = 3;
    public static final int MOST_VALUABLE_SENIORITY_LEVEL = 4;

    public static final Amount REGISTERED_DISCOUNT_INDEX = Amount.create(0.1d);
    public static final Amount VALUABLE_DISCOUNT_INDEX = Amount.create(0.7d);
    public static final Amount MOST_VALUABLE_DISCOUNT_INDEX = Amount.create(0.5d);

    public static final Seniority THRESHOLD_SENIORITY = Seniority.create(5);

    /**
     * To calculate the discount to be applied.
     * @param seniority
     * @return
     */
    public static Amount getDiscount(Seniority seniority) {

        double disc = (seniority.getValue() > THRESHOLD_SENIORITY.getValue()) ?
                THRESHOLD_SENIORITY.getValue()/100 : seniority.getValue()/100;

        return Amount.create(disc);
    }
}
