package com.creditcard.service;

import com.creditcard.DTO.CreditCardApplicationRequest;

public interface CreditCardApplicationService {

    public CreditCardApplicationRequest saveApplication(CreditCardApplicationRequest application);

    public CreditCardApplicationRequest updateApplication(CreditCardApplicationRequest application);
}
