package com.creditcard.repository;

import com.creditcard.entity.CreditCardApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, UUID> {

    List<CreditCardApplication> findByApplicationStatus(Byte applicationStatus);
}
