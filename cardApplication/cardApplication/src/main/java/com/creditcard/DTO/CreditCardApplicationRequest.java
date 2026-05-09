package com.creditcard.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardApplicationRequest {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String mobile;
    private String email;
    private String documentType;
    private String documentNumber;
    private String address;
    private Byte employmentType;
    private Double annualSalary;
}
