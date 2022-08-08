package com.msc.discount.manager.application.services;


import com.msc.discount.manager.domain.entities.CustomerEntity;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import com.msc.discount.manager.infrastructure.impl.DiscountCalculatorUtils;

/**
 * This class represents the operations to be done for the discount computing.
 *
 * The Singleton pattern is applied for the instance creation.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public class DiscountCalculatorServiceImpl implements DiscountCalculatorService {

    private static DiscountCalculatorServiceImpl instance;
    private Amount discountCalculated;

    private DiscountCalculatorServiceImpl() {

    }

    public static DiscountCalculatorServiceImpl getInstance() {
        if (instance == null) {
            instance = new DiscountCalculatorServiceImpl();
        }

        return instance;
    }

    @Override
    public Amount calculateDiscount(CustomerEntity customer) {

        switch (customer.getCustomerType().getValue()) {
            case DiscountCalculatorUtils.UNREGISTERED_SENIORITY_LEVEL:
                discountCalculated = customer.getAmount();
                break;
            case DiscountCalculatorUtils.REGISTERED_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithmWithIndex(
                        DiscountCalculatorUtils.REGISTERED_DISCOUNT_INDEX, customer);
                break;
            case DiscountCalculatorUtils.VALUABLE_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithm(
                        DiscountCalculatorUtils.VALUABLE_DISCOUNT_INDEX, customer);
                break;
            case DiscountCalculatorUtils.MOST_VALUABLE_SENIORITY_LEVEL:
                discountCalculated = applyDiscountAlgorithmWithIndex(
                        DiscountCalculatorUtils.MOST_VALUABLE_DISCOUNT_INDEX, customer);
                break;
        }

        return discountCalculated;
    }

    /**
     * Common discount algorithm.
     * @param discountIndex
     * @param customer
     * @return
     */
    private Amount applyDiscountAlgorithmWithIndex(Amount discountIndex, CustomerEntity customer) {
        return Amount.create(
                (customer.getAmount().getValue() -
                (discountIndex.getValue() *
                        customer.getAmount().getValue())) -
                DiscountCalculatorUtils.getDiscount(customer.getSeniority()).getValue() *
                        (customer.getAmount().getValue() -
                        (discountIndex.getValue() *
                                customer.getAmount().getValue()))
        );
    }

    /**
     * Standard discount algorithm.
     * @param discountIndex
     * @param customer
     * @return
     */
    private Amount applyDiscountAlgorithm(Amount discountIndex, CustomerEntity customer) {
        return Amount.create(
                (discountIndex.getValue() * customer.getAmount().getValue())
                - DiscountCalculatorUtils.getDiscount(customer.getSeniority()).getValue() *
                (discountIndex.getValue() * customer.getAmount().getValue())
        );
    }
}
