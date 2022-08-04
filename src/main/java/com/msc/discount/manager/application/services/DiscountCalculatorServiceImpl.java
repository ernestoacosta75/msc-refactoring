package com.msc.discount.manager.application.services;


import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import com.msc.discount.manager.infrastructure.impl.DiscountCalculatorUtils;

/**
 * This class represents the operations to be done for the discount computing.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public class DiscountCalculatorServiceImpl implements DiscountCalculatorService {

    private Amount discountCalculated;

    public DiscountCalculatorServiceImpl() {

    }

    @Override
    public Amount calculateDiscount(Amount amount, CustomerType customerType, Seniority seniority) {

        switch (customerType.getValue()) {
            case DiscountCalculatorUtils.UNREGISTERED_SENIORITY_LEVEL:
                discountCalculated = amount;
                break;
            case DiscountCalculatorUtils.REGISTERED_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithmWithIndex(DiscountCalculatorUtils.REGISTERED_DISCOUNT_INDEX, amount, seniority);
                break;
            case DiscountCalculatorUtils.VALUABLE_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithm(DiscountCalculatorUtils.VALUABLE_DISCOUNT_INDEX, amount, seniority);
                break;
            case DiscountCalculatorUtils.MOST_VALUABLE_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithmWithIndex(DiscountCalculatorUtils.MOST_VALUABLE_DISCOUNT_INDEX, amount, seniority);
                break;
        }

        return discountCalculated;
    }

    /**
     * Common discount algorithm.
     * @param discountIndex
     * @param amount
     * @param seniority
     * @return
     */
    private Amount applyDiscountAlgorithmWithIndex(Amount discountIndex, Amount amount, Seniority seniority) {
        return Amount.create(
                (amount.getValue() -
                (discountIndex.getValue() *
                        amount.getValue())) -
                DiscountCalculatorUtils.getDiscount(seniority).getValue() * (amount.getValue() -
                        (discountIndex.getValue() *
                                amount.getValue()))
        );
    }

    /**
     * Standard discount algorithm.
     * @param discountIndex
     * @param amount
     * @param seniority
     * @return
     */
    private Amount applyDiscountAlgorithm(Amount discountIndex, Amount amount, Seniority seniority) {
        return Amount.create(
                (discountIndex.getValue() * amount.getValue())
                - DiscountCalculatorUtils.getDiscount(seniority).getValue() *
                (discountIndex.getValue() * amount.getValue())
        );
    }
}
