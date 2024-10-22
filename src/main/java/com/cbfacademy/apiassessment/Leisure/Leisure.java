package com.cbfacademy.apiassessment.Leisure;

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
@Table(name = "leisure")
public class Leisure {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "leisure_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal entertainment; 
private BigDecimal diningOut;
private BigDecimal travel;
private BigDecimal sportsMembership;
private String frequency;

// Constructors: default and parameterized
public Leisure() {
this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}

public Leisure(UUID id, BigDecimal entertainment, BigDecimal diningOut, BigDecimal travel, BigDecimal sportsMembership, String frequency) {
    this.id= id;
    this.entertainment = entertainment;
    this.diningOut = diningOut;
    this.travel = travel;
    this.sportsMembership = sportsMembership;
    this.frequency = frequency;
}

public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setuser (User user) {
    this.user = user;
}
public BigDecimal getEntertainment() {
    return entertainment;
}

public void setEntertainment(BigDecimal entertainment) {
    this.entertainment = entertainment;
}

public BigDecimal getDiningOut() {
    return diningOut;
}

public void setDiningOut(BigDecimal diningOut) {
    this.diningOut = diningOut;
}

public BigDecimal getTravel() {
    return travel;
}

public void setTravel(BigDecimal travel) {
    this.travel = travel;
}

public BigDecimal getSportsMembership() {
    return sportsMembership;
}

public void setSportsMembership(BigDecimal sportsMembership) {
    this.sportsMembership = sportsMembership;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
