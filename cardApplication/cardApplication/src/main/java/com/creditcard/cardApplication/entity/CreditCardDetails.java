package com.creditcard.cardApplication.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "credit_card_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardDetails {

    @Id
    @GeneratedValue
    @Column(name = "card_id")
    private UUID cardId;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "card_type")
    private Byte cardType;

    @Column(name = "card_limit")
    private Long cardLimit;

    @Column(name = "expiry_month")
    private Byte expiryMonth;

    @Column(name = "expiry_year")
    private Integer expiryYear;

    @Column(name = "cvv")
    private Byte cvv;

    @Column(length = 20)
    private String pin;

    @Column(name = "system_generated")
    private Boolean systemGenerated;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;
}