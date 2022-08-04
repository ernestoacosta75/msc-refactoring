package com.msc.discount.manager.domain;

import com.msc.discount.manager.domain.services.DiscountCalculatorService;

/**
 * Base class for all the different calculators.
 * To be extend it.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public abstract class BasseCalclulator {

    protected DiscountCalculatorService discountCalculatorService;

    protected BasseCalclulator(DiscountCalculatorService discountCalculatorService) {

        this.discountCalculatorService = discountCalculatorService;
    }
}
