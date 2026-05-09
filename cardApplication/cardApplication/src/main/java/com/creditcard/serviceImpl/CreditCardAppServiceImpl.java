// package com.creditcard.serviceImpl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.creditcard.DTO.CreditCardApplication;

// @Service
// public class CreditCardAppServiceImpl {

//     private final CreditCardApplicationRepository repository;

//     public CreditCardApplicationServiceImpl(CreditCardApplicationRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public CreditCardApplication saveApplication(CreditCardApplication application) {
//         return repository.save(application);
//     }

//     @Override
//     public List<CreditCardApplication> getPendingApplications() {
//         return repository.findByStatus("PENDING");
//     }

//     @Override
//     public CreditCardApplication updateApplication(CreditCardApplication application) {
//         return repository.save(application);
//     }
// }
