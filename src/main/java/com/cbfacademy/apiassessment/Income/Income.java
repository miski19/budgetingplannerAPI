package com.cbfacademy.apiassessment.Income;


import java.math.BigDecimal;
import java.util.UUID;

import com.cbfacademy.apiassessment.User.User;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "income")
public class Income {
    
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "income_id")
private UUID id;



@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")

private User user;

private BigDecimal salaryAfterTaxes; 
private BigDecimal selfEmploymentIncome;
private BigDecimal statutorySickPay;
private BigDecimal statutoryMaternityPay;
private String frequency;


//Constructors: default and parameterized
public Income(){
this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}

public Income(UUID id, BigDecimal salaryAfterTaxes, BigDecimal selfEmploymentIncome, BigDecimal statutorySickPay, BigDecimal statutoryMaternityPay, String frequency) {
    this.id = id;
    this.salaryAfterTaxes = salaryAfterTaxes;
    this.selfEmploymentIncome = selfEmploymentIncome;
    this.statutorySickPay = statutorySickPay;
    this.statutoryMaternityPay = statutoryMaternityPay;
    this.frequency = frequency;
}

//Getters and setters
public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setUser (User user) {
    this.user = user;
}

public BigDecimal getSalaryAfterTaxes() {
    return salaryAfterTaxes;
}

public void setSalaryAfterTaxes (BigDecimal salaryAfterTaxes) {
    this.salaryAfterTaxes = salaryAfterTaxes;
}

public BigDecimal getSelfEmploymentIncome() {
    return selfEmploymentIncome;
}

public void setSelfEmploymentIncome(BigDecimal selfEmploymentIncome) {
    this.selfEmploymentIncome = selfEmploymentIncome;
}

public BigDecimal getStatutorySickPay() {
    return statutorySickPay;
}

public void setStatutorySickPay(BigDecimal statutorySickPay) {
    this.statutorySickPay = statutorySickPay;
}

public BigDecimal getStatutoryMaternityPay() {
    return statutoryMaternityPay;
}

public void setStatutoryMaternityPay(BigDecimal statutoryMaternityPay) {
    this.statutoryMaternityPay = statutoryMaternityPay;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}

}





