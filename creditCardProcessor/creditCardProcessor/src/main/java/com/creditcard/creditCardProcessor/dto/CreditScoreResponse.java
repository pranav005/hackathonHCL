package com.creditcard.creditCardProcessor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditScoreResponse {

    private final String isCreditScore;
    private final Integer creditScore;

    private CreditScoreResponse(String isCreditScore, Integer creditScore) {
        this.isCreditScore = isCreditScore;
        this.creditScore = creditScore;
    }

    public static CreditScoreResponse available(Integer score) {
        return new CreditScoreResponse("Available", score);
    }

    public static CreditScoreResponse notAvailable() {
        return new CreditScoreResponse("Not Available", null);
    }
}
