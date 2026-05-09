package com.creditcard.creditCardProcessor.service;

import com.creditcard.creditCardProcessor.dto.CreditScoreResponse;
import com.creditcard.creditCardProcessor.repository.CreditScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CibilService {

    private final CreditScoreRepository creditScoreRepository;

    public CreditScoreResponse getCreditScore(Short documentType, Long documentNumber) {
        return creditScoreRepository
                .findByDocumentTypeAndDocumentNumber(documentType, documentNumber)
                .map(entity -> CreditScoreResponse.available(entity.getCreditScore()))
                .orElse(CreditScoreResponse.notAvailable());
    }
}
