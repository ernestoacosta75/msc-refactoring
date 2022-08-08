package com.msc.discount.manager.infrastructure.impl;

import com.msc.discount.manager.domain.ICalculatorStrategy;
import com.msc.discount.manager.domain.entities.CustomerEntity;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

/**
 * This class defines the interface of interests to the
 * clients.
 * It maintains a reference to one of the strategy objects,
 * and doesn't know the concrete strategy implementations.
 * In that way, it can works with all the strategies via
 * the strategy interface.
 */
public class DiscountCalculationContext {

    private ICalculatorStrategy strategy;

    public void setStrategy(ICalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * The discount calculation is delegated to the
     * strategy object instead of implementing multiple
     * versions of the discount algorithm.
     * @param customer
     * @return
     */
    public Amount calculateDiscount(CustomerEntity customer) {
        return strategy.calculateDiscount(customer);
    }
}
