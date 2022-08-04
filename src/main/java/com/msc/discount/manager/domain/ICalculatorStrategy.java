package com.msc.discount.manager.domain;

import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

/**
 * This interface declares the common operation(s)
 * for the possible versions of the discount calculation algorithm.
 *
 * The context will use this interface to call the
 * discount calculation defined by the concrete implementations
 * of the strategy.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public interface ICalculatorStrategy {

    Amount calculateDiscount (Amount amount, CustomerType type, Seniority years);
}
