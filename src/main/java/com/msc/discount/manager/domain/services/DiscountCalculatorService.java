package com.msc.discount.manager.domain.services;


import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;

public interface DiscountCalculatorService {

    Amount calculateDiscount(Amount amount, CustomerType customerType, Seniority seniority);
}
