package com.msc.discount.manager.domain.services;


import com.msc.discount.manager.domain.entities.CustomerEntity;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

/**
 * This interface represents the operations to
 * be done for the discount computing.
 *
 * To be implemented.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public interface DiscountCalculatorService {

    Amount calculateDiscount(CustomerEntity customer);
}
