package com.msc.discount.manager.infrastructure.impl;

import com.msc.discount.manager.domain.ICalculatorStrategy;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

public class DiscountCalculationContext {

    private ICalculatorStrategy strategy;

    public void setStrategy(ICalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    public Amount calculateDiscount(Amount amount, CustomerType customerType, Seniority seniority) {
        return strategy.calculateDiscount(amount, customerType, seniority);
    }
}
