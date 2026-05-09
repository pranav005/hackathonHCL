package com.creditcard.serviceImpl;

import com.creditcard.DTO.CreditCardApplicationRequest;
import com.creditcard.DTO.CreditCardApplicationResponse;
import com.creditcard.entity.CreditCardApplication;
import com.creditcard.repository.CreditCardApplicationRepository;
import com.creditcard.service.CreditCardApplicationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditCardAppServiceImpl implements CreditCardApplicationService {

    private static final byte STATUS_NEW = 0;

    private final CreditCardApplicationRepository repository;

    public CreditCardAppServiceImpl(CreditCardApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreditCardApplicationResponse applyForCreditCard(CreditCardApplicationRequest request) {
        CreditCardApplication application = CreditCardApplication.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(LocalDate.parse(request.getDateOfBirth()))
                .mobileNo(Long.parseLong(request.getMobile()))
                .email(request.getEmail())
                .documentType(request.getDocumentType())
                .documentNumber(request.getDocumentNumber())
                .address(request.getAddress())
                .employmentType(request.getEmploymentType())
                .annualIncome(request.getAnnualSalary().longValue())
                .applicationStatus(STATUS_NEW)
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        CreditCardApplication saved = repository.save(application);

        return new CreditCardApplicationResponse(
                saved.getCreditCardApplicationId(),
                "Application Received for Credit Card"
        );
    }
}
