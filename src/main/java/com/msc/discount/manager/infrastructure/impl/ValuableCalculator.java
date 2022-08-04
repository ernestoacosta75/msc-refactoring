package com.msc.discount.manager.infrastructure.impl;

import com.msc.discount.manager.domain.BasseCalclulator;
import com.msc.discount.manager.domain.ICalculatorStrategy;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

/**
 * This class represents the concrete implementation
 * of the discount calculation algorithm for the
 * valuable customers.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public class ValuableCalculator extends BasseCalclulator implements ICalculatorStrategy {

    public ValuableCalculator(DiscountCalculatorService discountCalculatorService) {
        super(discountCalculatorService);
    }

    @Override
    public Amount calculateDiscount(Amount amount, CustomerType customerType, Seniority seniority) {

        return this.discountCalculatorService.calculateDiscount(amount, customerType, seniority);
    }
}
