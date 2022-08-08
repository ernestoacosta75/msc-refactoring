package com.msc.discount.manager.infrastructure.impl;

import com.msc.discount.manager.domain.BasseCalclulator;
import com.msc.discount.manager.domain.ICalculatorStrategy;
import com.msc.discount.manager.domain.entities.CustomerEntity;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;

public class CustomerDiscountCalculator extends BasseCalclulator implements ICalculatorStrategy {

    public CustomerDiscountCalculator(DiscountCalculatorService discountCalculatorService) {
        super(discountCalculatorService);
    }

    @Override
    public Amount calculateDiscount(CustomerEntity customer) {

        return this.discountCalculatorService.calculateDiscount(customer);
    }
}
