package com.creditcard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreditCardApplicationResponse {

    private UUID creditCardApplicationId;
    private String message;
}
