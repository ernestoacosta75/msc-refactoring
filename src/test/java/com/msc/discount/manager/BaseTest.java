package com.msc.discount.manager;

import com.msc.discount.manager.application.services.DiscountCalculatorServiceImpl;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import com.msc.discount.manager.infrastructure.impl.MosValuableCalculator;
import com.msc.discount.manager.infrastructure.impl.RegisteredCalculator;
import com.msc.discount.manager.infrastructure.impl.UnregisteredCalculator;
import com.msc.discount.manager.infrastructure.impl.ValuableCalculator;

public class BaseTest {

    protected DiscountCalculatorService discountCalculatorService = new DiscountCalculatorServiceImpl();

    protected Amount validAmount = Amount.create(1.0d);
    protected CustomerType validRegisteredCustomerType = CustomerType.create(1);
    protected CustomerType validUnregisteredCustomerType = CustomerType.create(2);
    protected CustomerType validValuableCustomerType = CustomerType.create(3);
    protected CustomerType validMostValuableCustomerType = CustomerType.create(4);
    protected Seniority validSeniority = Seniority.create(4);

    protected Amount inValidAmount = Amount.create(-2.20d);
    protected CustomerType inValidCustomerType = CustomerType.create(-2);
    protected Seniority inValidSeniority = Seniority.create(-4);

    protected UnregisteredCalculator unregisteredCalculator =
            new UnregisteredCalculator(discountCalculatorService);

    protected RegisteredCalculator registeredCalculator =
            new RegisteredCalculator(discountCalculatorService);

    protected ValuableCalculator valuableCalculator =
            new ValuableCalculator(discountCalculatorService);

    protected MosValuableCalculator mosValuableCalculator =
            new MosValuableCalculator(discountCalculatorService);
}
