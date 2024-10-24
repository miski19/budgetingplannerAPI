package com.cbfacademy.apiassessment.User;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.BenefitsandTaxCredits.BenefitsAndTaxCredits;
import com.cbfacademy.apiassessment.Bills.Bills;
import com.cbfacademy.apiassessment.Income.Income;
import com.cbfacademy.apiassessment.Leisure.Leisure;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncome;
import com.cbfacademy.apiassessment.Pensions.Pensions;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table(name="user")

public class User {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;

private String name;
private String email;
private BigDecimal userPercentage;
private Instant dateTime;


//User link to other models
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Income> income = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<BenefitsAndTaxCredits> benefitsAndTaxCredits = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Pensions> pensions = new ArrayList<>();

@OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<OtherIncome> otherIncome = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Bills> bills = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Leisure> leisure = new ArrayList<>();



//Constructors: default and parameterized
public User() {
    this(null, null, Instant.now());
}
  

public User(String name, String email, Instant dateTime) {
    this.name = name;
    this.email = email;
    this.dateTime = dateTime;
    
}

// Getters and setters
public UUID getId() {
    return id;
}

public String getName(){
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}

public Instant getDateTime() {
    return dateTime;
}
public void setDateTime(Instant dateTime) {
    this.dateTime = dateTime;
}

public BigDecimal getUserPercentage() {
    return userPercentage;
}

public void setUserPercentage (BigDecimal userPercentage) {
    this.userPercentage = userPercentage;
}
}

