package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

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
@Table(name= "benefitsAndTaxCredits")
public class BenefitsAndTaxCredits {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "benefitsAndTaxCredits")
private UUID id;

@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    

    private BigDecimal jobSeekersAllowance;
    private BigDecimal workingTaxCredit;
    private BigDecimal childTaxCredit;
    private BigDecimal childBenefit;
    private BigDecimal employmentSupportAllowance;
    private BigDecimal universalCredit;
    private BigDecimal disabilityAllowance;
    private BigDecimal attendanceAllowance;
    private BigDecimal carersAllowance;
    private BigDecimal housingBenefit;
    private BigDecimal maternityAllowance;
    private String frequency; 
    
   

//Constructors: default and parameterized
public BenefitsAndTaxCredits() {
this(null,  BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 
    BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
   
    }

 

public BenefitsAndTaxCredits(UUID id, BigDecimal jobSeekersAllowance, BigDecimal workingTaxCredit, BigDecimal childTaxCredit, BigDecimal childBenefit,
BigDecimal employmentSupportAllowance, BigDecimal universalCredit, BigDecimal disabilityAllowance, BigDecimal attendanceAllowance,
BigDecimal carersAllowance, BigDecimal housingBenefit, BigDecimal maternityAllowance, String frequency) {
this.id = id;
this.jobSeekersAllowance = jobSeekersAllowance;
this.workingTaxCredit = workingTaxCredit;
this.childTaxCredit = childTaxCredit;
this.childBenefit = childBenefit;
this.employmentSupportAllowance = employmentSupportAllowance;
this.universalCredit = universalCredit;
this.disabilityAllowance = disabilityAllowance;
this.attendanceAllowance = attendanceAllowance;
this.carersAllowance = carersAllowance;
this.housingBenefit = housingBenefit;
this.maternityAllowance= maternityAllowance;
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
public BigDecimal getJobSeekersAllowance() {
    return jobSeekersAllowance;
}

public void setJobSeekersAllowance(BigDecimal jobSeekersAllowance) {
    this.jobSeekersAllowance = jobSeekersAllowance;
}

public BigDecimal getWorkingTaxCredit() {
    return workingTaxCredit;
}

public void setWorkingTaxCredit(BigDecimal workingTaxCredit) {
    this.workingTaxCredit = workingTaxCredit;
}

public BigDecimal getChildTaxCredit() {
    return childTaxCredit;
}

public void setChildTaxCredit(BigDecimal childTaxCredit) {
    this.childTaxCredit = childTaxCredit;
}

public BigDecimal getChildBenefit() {
    return childBenefit;
}

public void setChildBenefit(BigDecimal childBenefit) {
    this.childBenefit = childBenefit;
}

public BigDecimal getEmploymentSupportAllowance() {
    return employmentSupportAllowance;
}

public void setEmploymentSupportAllowance(BigDecimal employmentSupportAllowance) {
    this.employmentSupportAllowance = employmentSupportAllowance;
}

public BigDecimal getUniversalCredit() {
    return universalCredit;
}

public void setUniversalCredit(BigDecimal universalCredit) {
    this.universalCredit = universalCredit;
}

public BigDecimal getDisabilityAllowance() {
    return disabilityAllowance;
}

public void setDisabilityAllowance(BigDecimal disabilityAllowance) {
    this.disabilityAllowance = disabilityAllowance;
}

public BigDecimal getAttendanceAllowance() {
    return attendanceAllowance;
}

public void setAttendanceAllowance(BigDecimal attendanceAllowance) {
    this.attendanceAllowance = attendanceAllowance;
}

public BigDecimal getCarersAllowance() {
    return carersAllowance;
}

public void setCarersAllowance(BigDecimal carersAllowance) {
    this.carersAllowance = carersAllowance;
}

public BigDecimal getHousingBenefit() {
     return housingBenefit;
}
public void setHousingBenefit(BigDecimal housingBenefit) {
    this.housingBenefit = housingBenefit;
}
public BigDecimal getMaternityAllowance() {
    return maternityAllowance;
}
public void setMaternityAllowance(BigDecimal maternityAllowance) {
    this.maternityAllowance= maternityAllowance;
}
public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
