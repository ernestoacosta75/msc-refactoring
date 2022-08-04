package com.msc.discount.manager;

import com.msc.discount.manager.application.services.DiscountCalculatorServiceImpl;
import com.msc.discount.manager.domain.services.DiscountCalculatorService;
import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import com.msc.discount.manager.infrastructure.impl.DiscountCalculationContext;
import com.msc.discount.manager.infrastructure.impl.DiscountCalculatorUtils;
import com.msc.discount.manager.infrastructure.impl.UnregisteredCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Once the main method is running, in the terminal window of the IDE
 * will be asked to enter the following parameters:
 * - Amount (the value to type must be done using comma, ex.: 2,20)
 * - Customer type (an integer value)
 * - Seniority (an integer value)
 */
public class DiscountCalculatorDemoTest {

    public static void main(String[] args) {
        DiscountCalculatorService discountCalculatorService = new DiscountCalculatorServiceImpl();
        DecimalFormat f = new DecimalFormat("##.000");
        DiscountCalculationContext discountCalculationContext = new DiscountCalculationContext();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount:");
        Amount amount = Amount.create(sc.nextDouble());

        System.out.println("Enter the customer type:");
        CustomerType customerType = CustomerType.create(sc.nextInt());

        System.out.println("Enter the seniority:");
        Seniority seniority = Seniority.create(sc.nextInt());

        switch (customerType.getValue()) {
            case DiscountCalculatorUtils.UNREGISTERED_SENIORITY_LEVEL:
                discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));
                break;
            case DiscountCalculatorUtils.REGISTERED_SENIORITY_LEVEL:
                discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));
                break;
            case DiscountCalculatorUtils.VALUABLE_SENIORITY_LEVEL:
                discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));
                break;
            case DiscountCalculatorUtils.MOST_VALUABLE_SENIORITY_LEVEL:
                discountCalculationContext.setStrategy(new UnregisteredCalculator(discountCalculatorService));
                break;
        }

        Amount discountApplied = discountCalculationContext
                .calculateDiscount(amount, customerType, seniority);

        System.out.println(String.format("The discount applied for the client is %n " +
                f.format(discountApplied.getValue())));
    }
}
