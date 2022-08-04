package com.msc.discount.manager.domain;

import com.msc.discount.manager.application.services.DiscountCalculatorServiceImpl;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import com.msc.discount.manager.infrastructure.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is used for the integrations tests
 * regarding the components of the Discount Manager.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
class CalculatorTests {

    private DiscountCalculatorService discountCalculatorService = new DiscountCalculatorServiceImpl();
    DiscountCalculationContext discountCalculationContext = new DiscountCalculationContext();

    @Test
    void whenCreateContextInstanceWithWrongAmount_ThenTriggerException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Amount amount = Amount.create(-2.20d);
        });

        String expectedMessage = "The amount must be bigger than zero.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

  @Test
    void whenCreateContextInstanceWithWrongCustomerType_ThenTriggerException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomerType customerType = CustomerType.create(-2);
        });

        String expectedMessage = "The customer type value must be bigger than zero.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenCreateContextInstanceWithWrongSeniority_ThenTriggerException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Seniority seniority = Seniority.create(-4);

            discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));

        });

        String expectedMessage = "The seniority must be bigger than zero.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenUnregisteredStrategySettedIsValid_ThenReturnDiscount() {
        Amount amount = Amount.create(1.0d);
        CustomerType customerType = CustomerType.create(1);
        Seniority seniority = Seniority.create(4);

        discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));

        Amount discount = discountCalculationContext
                .calculateDiscount(amount, customerType, seniority);

        Assertions.assertTrue(discount != null);
        Assertions.assertTrue(discount.getValue() == amount.getValue());
    }

    @Test
    void whenRegisteredStrategySettedIsValid_ThenReturnDiscount() {
        Amount amount = Amount.create(1.0d);
        CustomerType customerType = CustomerType.create(2);
        Seniority seniority = Seniority.create(4);

        discountCalculationContext.setStrategy(new RegisteredCalculator(discountCalculatorService));

        Amount discount = discountCalculationContext
                .calculateDiscount(amount, customerType, seniority);

        Assertions.assertTrue(discount != null);
    }

    @Test
    void whenValuableStrategySettedIsValid_ThenReturnDiscount() {
        Amount amount = Amount.create(1.0d);
        CustomerType customerType = CustomerType.create(3);
        Seniority seniority = Seniority.create(4);

        discountCalculationContext.setStrategy(new ValuableCalculator(discountCalculatorService));

        Amount discount = discountCalculationContext
                .calculateDiscount(amount, customerType, seniority);

        Assertions.assertTrue(discount != null);
    }

    @Test
    void whenMostValuableStrategySettedIsValid_ThenReturnDiscount() {
        Amount amount = Amount.create(1.0d);
        CustomerType customerType = CustomerType.create(4);
        Seniority seniority = Seniority.create(4);

        discountCalculationContext.setStrategy(new MosValuableCalculator(discountCalculatorService));

        Amount discount = discountCalculationContext
                .calculateDiscount(amount, customerType, seniority);

        Assertions.assertTrue(discount != null);
    }
}
