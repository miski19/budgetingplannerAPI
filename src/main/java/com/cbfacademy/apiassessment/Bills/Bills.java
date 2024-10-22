package com.cbfacademy.apiassessment.Bills;

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
@Table(name = "bills")
public class Bills {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "bills_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal rent;
private BigDecimal mortgage; 
private BigDecimal mortgageEndowment;
private BigDecimal councilTax;
private BigDecimal insurance;
private BigDecimal utilities;
private BigDecimal groceries;
private String frequency;


//Constructors: default and parameterized
public Bills() {
    this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
         BigDecimal.ZERO, "monthly");
}

public Bills(UUID id, BigDecimal rent, BigDecimal mortgage, BigDecimal mortgageEndowment, BigDecimal councilTax,
        BigDecimal insurance, BigDecimal utilities, BigDecimal groceries, String frequency) {
    this.id = id;
    this.rent = rent;
    this.mortgage = mortgage;
    this.mortgageEndowment = mortgageEndowment;
    this.councilTax = councilTax;
    this.insurance = insurance;
    this.utilities = utilities;
    this.groceries = groceries;
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
public BigDecimal getRent() {
    return rent;
}

public void setRent(BigDecimal rent) {
    this.rent = rent;
}

public BigDecimal getMortgage() {
    return mortgage;
}

public void setMortgage(BigDecimal mortgage) {
    this.mortgage = mortgage;
}

public BigDecimal getMortgageEndowment() {
    return mortgageEndowment;
}

public void setMortgageEndowment(BigDecimal mortgageEndowment) {
    this.mortgageEndowment = mortgageEndowment;
}

public BigDecimal getCouncilTax() {
    return councilTax;
}

public void setCouncilTax(BigDecimal councilTax) {
    this.councilTax= councilTax;
}

public BigDecimal getInsurance() {
    return insurance;
}

public void setInsurance(BigDecimal insurance) {
    this.insurance = insurance;
}

public BigDecimal getUtilities() {
    return utilities;
}

public void setUtilities(BigDecimal utilities) {
    this.utilities = utilities;
}

public BigDecimal getGroceries() {
    return groceries;
}

public void setGroceries(BigDecimal groceries) {
    this.groceries = groceries;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}

}
