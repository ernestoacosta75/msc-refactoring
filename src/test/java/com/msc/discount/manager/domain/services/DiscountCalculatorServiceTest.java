package com.msc.discount.manager.domain.services;

import com.msc.discount.manager.application.services.DiscountCalculatorServiceImpl;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used for the unit test
 * regarding the DiscountCalculatoService.
 *
 * @author Ernesto A. Rodrigue Acosta
 */
class DiscountCalculatorServiceTest {

    private DiscountCalculatorService discountCalculatorService = new DiscountCalculatorServiceImpl();

    @Test
    void whenCalculateDiscountWithValidValues_ThenReturnDiscount() {
        Amount amount = Amount.create(1.0d);
        CustomerType customerType = CustomerType.create(3);
        Seniority seniority = Seniority.create(4);

        Amount discount = discountCalculatorService.calculateDiscount(amount, customerType, seniority);

        Assertions.assertTrue(discount != null);
    }

}
