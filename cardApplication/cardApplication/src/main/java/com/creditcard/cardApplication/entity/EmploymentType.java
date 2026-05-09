package com.creditcard.cardApplication.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employment_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentType {

    @Id
    @Column(name = "id")
    private Byte id;
}