package com.msc.discount.manager.domain.entities;

import com.msc.discount.manager.domain.vo.Amount;
import com.msc.discount.manager.domain.vo.CustomerType;
import com.msc.discount.manager.domain.vo.Seniority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    private UUID id;
    private Amount amount;
    private CustomerType customerType;
    private Seniority seniority;

    public CustomerEntity(Amount amount, CustomerType customerType, Seniority seniority) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.customerType = customerType;
        this.seniority = seniority;
    }

}
