package com.creditcard.creditCardProcessor.controller;

import com.creditcard.creditCardProcessor.dto.CreditScoreResponse;
import com.creditcard.creditCardProcessor.service.CibilService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit-score")
@RequiredArgsConstructor
@Validated
public class CibilController {

    private final CibilService cibilService;

    @GetMapping
    public CreditScoreResponse getCreditScore(
            @RequestParam @NotNull @Min(value = 1, message = "must be at least 1") Short documentType,
            @RequestParam @NotNull
            @Min(value = 1000000000L, message = "must be a 10-digit number")
            @Max(value = 9999999999L, message = "must be a 10-digit number")
            Long documentNumber) {
        return cibilService.getCreditScore(documentType, documentNumber);
    }
}
