package com.creditcard.service;

import com.creditcard.DTO.CreditCardApplicationRequest;
import com.creditcard.DTO.CreditCardApplicationResponse;

public interface CreditCardApplicationService {

    CreditCardApplicationResponse applyForCreditCard(CreditCardApplicationRequest request);
}
