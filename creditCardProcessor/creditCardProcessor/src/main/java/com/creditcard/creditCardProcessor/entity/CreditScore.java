package com.creditcard.creditCardProcessor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "credit_score")
@Getter
@Setter
@NoArgsConstructor
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "credit_score_id", nullable = false, updatable = false)
    private UUID creditScoreId;

    @Column(name = "document_type", nullable = false)
    private Short documentType;

    @Column(name = "document_number", nullable = false)
    private Long documentNumber;

    @Column(name = "credit_score", nullable = false)
    private Integer creditScore;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
