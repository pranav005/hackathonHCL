package com.creditcard.DTO;

public class CreditCardApplicationRequest {
    private String applicationStatus;
    private String cardType;
    private String comments;
    private String employmentType;
    private Double annualIncome;
    private String firstName;
    private String mobileNo;
    private String email;
    private String dateOfBirth;
    private String address;
    private String create_at;
    private String updated_at;
    private String document_type;
    private String document_number;
    
    public String getApplicationStatus() {
        return applicationStatus;
    }
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getEmploymentType() {
        return employmentType;
    }
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
    public Double getAnnualIncome() {
        return annualIncome;
    }
    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCreate_at() {
        return create_at;
    }
    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    public String getDocument_type() {
        return document_type;
    }
    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }
    public String getDocument_number() {
        return document_number;
    }
    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }


}
