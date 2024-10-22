package com.cbfacademy.apiassessment.Pensions;

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
@Table(name = "pensions")
public class Pensions {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "pensions_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal statePension;
private BigDecimal privatePension;
private String frequency;

//Constructors: default and parameterized
public Pensions() {
    this(null, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}


public Pensions(UUID id, BigDecimal statePension, BigDecimal privatePension, String frequency) {
    this.id = id;
    this.statePension = statePension;
    this.privatePension = privatePension;
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
public BigDecimal getStatePension() {
    return statePension;
}


public void setStatePension(BigDecimal statePension) {
    this.statePension = statePension;
}


public BigDecimal getPrivatePension() {
    return privatePension;
}


public void setPrivatePension(BigDecimal privatePension) {
    this.privatePension = privatePension;
}


public String getFrequency() {
    return frequency;
}


public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
