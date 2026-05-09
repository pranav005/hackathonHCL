package com.creditcard.service;

import com.creditcard.DTO.CreditCardApplication;

public interface CreditCardApplicationService {

    public CreditCardApplication saveApplication(CreditCardApplication application);

    public CreditCardApplication updateApplication(CreditCardApplication application);
}
