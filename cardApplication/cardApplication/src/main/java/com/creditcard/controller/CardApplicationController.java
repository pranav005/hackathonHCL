package com.creditcard.controller;

import com.creditcard.DTO.CreditCardApplicationRequest;
import com.creditcard.DTO.CreditCardApplicationResponse;
import com.creditcard.service.CreditCardApplicationService;
import com.creditcard.serviceImpl.CreditCardCronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit-card")
public class CardApplicationController {

    private final CreditCardApplicationService service;
    private final CreditCardCronService cronService;

    public CardApplicationController(CreditCardApplicationService service,
                                     CreditCardCronService cronService) {
        this.service = service;
        this.cronService = cronService;
    }

    @PostMapping("/apply")
    public ResponseEntity<CreditCardApplicationResponse> applyForCreditCard(
            @RequestBody CreditCardApplicationRequest request) {
        CreditCardApplicationResponse response = service.applyForCreditCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/process")
    public ResponseEntity<String> triggerProcessing() {
        cronService.processNewApplications();
        return ResponseEntity.ok("Processing triggered successfully");
    }
}
