package com.creditcard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "credit_card_application")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardApplication {

    @Id
    @GeneratedValue
    @Column(name = "credit_card_application_id")
    private UUID creditCardApplicationId;

    @Column(name = "application_status")
    private Byte applicationStatus;

    @Column(name = "card_type")
    private Byte cardType;

    @Column(length = 100)
    private String comments;

    @Column(name = "employment_type")
    private Byte employmentType;

    @Column(name = "annual_income")
    private Long annualIncome;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(length = 100)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private String documentNumber;
}