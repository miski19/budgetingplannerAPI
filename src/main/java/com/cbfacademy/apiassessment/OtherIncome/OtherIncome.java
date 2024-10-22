package com.cbfacademy.apiassessment.OtherIncome;

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
@Table(name = "otherincome")
public class OtherIncome {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "otherincome_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal rentalIncome;
private BigDecimal investmentIncome;
private String frequency;

//Constructors: default and parameterized
public OtherIncome() {
this(null, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}


public OtherIncome(UUID id, BigDecimal rentalIncome, BigDecimal investmentIncome, String frequency) {
    this.id = id;
    this.rentalIncome = rentalIncome;
    this.investmentIncome = investmentIncome;
    this.frequency = frequency;
}

//Getters and setters
public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setuser (User user) {
    this.user = user;
}

public BigDecimal getRentalIncome() {
    return rentalIncome;
}


public void setRentalIncome(BigDecimal rentalIncome) {
    this.rentalIncome = rentalIncome;
}


public BigDecimal getInvestmentIncome() {
    return investmentIncome;
}


public void setInvestmentIncome(BigDecimal investmentIncome) {
    this.investmentIncome = investmentIncome;
}


public String getFrequency() {
    return frequency;
}


public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
