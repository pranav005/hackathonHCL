package com.creditcard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_card_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardType {

    @Id
    @Column(name = "id")
    private Byte id;
}