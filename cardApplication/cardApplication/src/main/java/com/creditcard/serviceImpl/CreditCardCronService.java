package com.creditcard.serviceImpl;

import com.creditcard.DTO.CreditScoreResponse;
import com.creditcard.entity.CreditCardApplication;
import com.creditcard.repository.CreditCardApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditCardCronService {

    private static final Logger log = LoggerFactory.getLogger(CreditCardCronService.class);

    // Application status codes
    private static final byte STATUS_NEW = 0;
    private static final byte STATUS_APPROVED = 1;
    private static final byte STATUS_ADDITIONAL_DOCS_REQUIRED = 2;

    // Card type codes
    private static final byte CARD_PLATINUM = 0;
    private static final byte CARD_GOLD = 1;
    private static final byte CARD_VISA = 2;

    // Credit score thresholds
    private static final int SCORE_PLATINUM = 500;
    private static final int SCORE_GOLD = 300;
    private static final int SCORE_VISA = 150;
    private static final int SCORE_ADDITIONAL_DOCS = 50;

    // Salary thresholds (annual, USD) used when credit score is not available
    private static final long SALARY_PLATINUM = 80000L;
    private static final long SALARY_GOLD = 40000L;
    private static final long SALARY_VISA = 20000L;
    private static final long SALARY_ADDITIONAL_DOCS = 5000L;

    private final CreditCardApplicationRepository repository;
    private final RestTemplate restTemplate;

    @Value("${credit.processor.base-url}")
    private String processorBaseUrl;

    public CreditCardCronService(CreditCardApplicationRepository repository,
                                 RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void processNewApplications() {
        log.info("Cron job started: processing NEW credit card applications");

        List<CreditCardApplication> newApplications =
                repository.findByApplicationStatus(STATUS_NEW);

        if (newApplications.isEmpty()) {
            log.info("No NEW applications to process");
            return;
        }

        log.info("Found {} NEW application(s) to process", newApplications.size());

        for (CreditCardApplication application : newApplications) {
            try {
                processApplication(application);
            } catch (Exception e) {
                log.error("Failed to process application {}: {}",
                        application.getCreditCardApplicationId(), e.getMessage());
            }
        }

        log.info("Cron job completed");
    }

    private void processApplication(CreditCardApplication application) {
        int creditScore = fetchCreditScore(application);
        applyCardDecision(application, creditScore);
        application.setUpdatedAt(LocalDate.now());
        repository.save(application);
        log.info("Application {} processed — score: {}, status: {}, cardType: {}",
                application.getCreditCardApplicationId(), creditScore,
                application.getApplicationStatus(), application.getCardType());
    }

    private int fetchCreditScore(CreditCardApplication application) {
        try {
            String url = UriComponentsBuilder.fromUriString(processorBaseUrl + "/api/credit-score")
                    .queryParam("documentType", Short.parseShort(application.getDocumentType()))
                    .queryParam("documentNumber", Long.parseLong(application.getDocumentNumber()))
                    .toUriString();

            CreditScoreResponse response = restTemplate.getForObject(url, CreditScoreResponse.class);

            if (response != null && response.isAvailable()) {
                log.info("Credit score available from processor for application {}",
                        application.getCreditCardApplicationId());
                return response.getCreditScore();
            }
        } catch (Exception e) {
            log.warn("Could not fetch credit score from processor for application {}: {}",
                    application.getCreditCardApplicationId(), e.getMessage());
        }

        log.info("Calculating score from salary for application {}",
                application.getCreditCardApplicationId());
        return scoreFromSalary(application.getAnnualIncome());
    }

    private int scoreFromSalary(Long annualIncome) {
        if (annualIncome == null) return 0;
        if (annualIncome >= SALARY_PLATINUM) return SCORE_PLATINUM;
        if (annualIncome >= SALARY_GOLD)     return SCORE_GOLD;
        if (annualIncome >= SALARY_VISA)     return SCORE_VISA;
        if (annualIncome >= SALARY_ADDITIONAL_DOCS) return SCORE_ADDITIONAL_DOCS;
        return 0;
    }

    private void applyCardDecision(CreditCardApplication application, int creditScore) {
        application.setCreditScore(creditScore);

        if (creditScore >= SCORE_PLATINUM) {
            application.setApplicationStatus(STATUS_APPROVED);
            application.setCardType(CARD_PLATINUM);
            application.setCreditLimit(40000L);
        } else if (creditScore >= SCORE_GOLD) {
            application.setApplicationStatus(STATUS_APPROVED);
            application.setCardType(CARD_GOLD);
            application.setCreditLimit(20000L);
        } else if (creditScore >= SCORE_VISA) {
            application.setApplicationStatus(STATUS_APPROVED);
            application.setCardType(CARD_VISA);
            application.setCreditLimit(10000L);
        } else {
            // score < 150 (includes >= 50 and < 50) — request additional documents
            application.setApplicationStatus(STATUS_ADDITIONAL_DOCS_REQUIRED);
            application.setCardType(null);
            application.setCreditLimit(null);
        }
    }
}
