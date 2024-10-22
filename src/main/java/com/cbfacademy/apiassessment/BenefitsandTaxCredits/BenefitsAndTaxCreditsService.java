package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class BenefitsAndTaxCreditsService {
public BenefitsAndTaxCreditsRepository benefitsAndTaxCreditsRepository;

public BenefitsAndTaxCreditsService(BenefitsAndTaxCreditsRepository benefitsAndTaxCreditsRepository){
    this.benefitsAndTaxCreditsRepository = benefitsAndTaxCreditsRepository;
}

public List<BenefitsAndTaxCredits> findBenefitsAndTaxCredits(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findBenefitsAndTaxCredits(id);
}

public List<BenefitsAndTaxCredits> findJobSeekersAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findCarersAllowance(id);
}

public List<BenefitsAndTaxCredits> findWorkingTaxCredit(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findWorkingTaxCredit(id);
}

public List<BenefitsAndTaxCredits> findChildTaxCredit(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findChildTaxCredit(id);
}

public List<BenefitsAndTaxCredits> findChildBenefit(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findChildBenefit(id);
}

public List<BenefitsAndTaxCredits> findEmploymentSupportAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findEmploymentSupportAllowance(id);
}

public List<BenefitsAndTaxCredits> findUniversalCredit(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findUniversalCredit(id);
}
public List<BenefitsAndTaxCredits> findDisabilityAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findDisabilityAllowance(id);
}

public List<BenefitsAndTaxCredits> findAttendanceAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findAttendanceAllowance(id);
}

public List<BenefitsAndTaxCredits> findCarersAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findCarersAllowance(id);
}

public List<BenefitsAndTaxCredits> findHousingBenefit(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findHousingBenefit(id);
}

public List<BenefitsAndTaxCredits> findMaternityAllowance(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findMaternityAllowance(id);
}

public List<BenefitsAndTaxCredits> findFrequency(String frequency) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findByFrequency(frequency);
}

public BenefitsAndTaxCredits createBenefitsAndTaxCredits(BenefitsAndTaxCredits benefitsAndTaxCredits)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return benefitsAndTaxCreditsRepository.save(benefitsAndTaxCredits);
}

BenefitsAndTaxCredits updateBenefitsAndTaxCredits(UUID id, BenefitsAndTaxCredits updatedBenefitsAndTaxCredits)
throws NoSuchElementException, IllegalArgumentException{
    BenefitsAndTaxCredits benefitsAndTaxCredits = benefitsAndTaxCreditsRepository.findById(id).orElseThrow();
    
    benefitsAndTaxCredits.setuser(updatedBenefitsAndTaxCredits.getUser());
    benefitsAndTaxCredits.setJobSeekersAllowance(updatedBenefitsAndTaxCredits.getJobSeekersAllowance()!= null ? updatedBenefitsAndTaxCredits.getJobSeekersAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setWorkingTaxCredit(updatedBenefitsAndTaxCredits.getWorkingTaxCredit()!= null ? updatedBenefitsAndTaxCredits.getWorkingTaxCredit() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setChildTaxCredit(updatedBenefitsAndTaxCredits.getChildTaxCredit()!= null ? updatedBenefitsAndTaxCredits.getChildTaxCredit() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setChildBenefit(updatedBenefitsAndTaxCredits.getChildBenefit()!= null ? updatedBenefitsAndTaxCredits.getChildBenefit() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setEmploymentSupportAllowance(updatedBenefitsAndTaxCredits.getEmploymentSupportAllowance()!= null ? updatedBenefitsAndTaxCredits.getEmploymentSupportAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setUniversalCredit(updatedBenefitsAndTaxCredits.getUniversalCredit()!= null ? updatedBenefitsAndTaxCredits.getUniversalCredit() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setDisabilityAllowance(updatedBenefitsAndTaxCredits.getDisabilityAllowance()!= null ? updatedBenefitsAndTaxCredits.getDisabilityAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setAttendanceAllowance(updatedBenefitsAndTaxCredits.getAttendanceAllowance()!= null ? updatedBenefitsAndTaxCredits.getAttendanceAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setCarersAllowance(updatedBenefitsAndTaxCredits.getCarersAllowance()!= null ? updatedBenefitsAndTaxCredits.getCarersAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setHousingBenefit(updatedBenefitsAndTaxCredits.getHousingBenefit()!= null ? updatedBenefitsAndTaxCredits.getHousingBenefit() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setMaternityAllowance(updatedBenefitsAndTaxCredits.getMaternityAllowance()!= null ? updatedBenefitsAndTaxCredits.getMaternityAllowance() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setFrequency(updatedBenefitsAndTaxCredits.getFrequency());
    
    return benefitsAndTaxCreditsRepository.save(updatedBenefitsAndTaxCredits);
}
     
        
    
public void deleteBenefitsAndTaxCredits(UUID id){
    if(!benefitsAndTaxCreditsRepository.existsById(id)){
        throw new NoSuchElementException("Benefit Not Found");
    }
        benefitsAndTaxCreditsRepository.deleteById(id);
}
}

