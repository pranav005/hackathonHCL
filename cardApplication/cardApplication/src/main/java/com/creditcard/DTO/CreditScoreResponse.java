package com.creditcard.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditScoreResponse {

    private String isCreditScore;
    private Integer creditScore;

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(isCreditScore);
    }
}
