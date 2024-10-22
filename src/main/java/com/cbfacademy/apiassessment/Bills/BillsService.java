package com.cbfacademy.apiassessment.Bills;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;




@Service
public class BillsService {
public BillsRepository billsRepository;

public BillsService(BillsRepository billsRepository) {
    this.billsRepository = billsRepository;
}

public List<Bills> findBills(UUID id) throws NoSuchElementException  {
    return billsRepository.findBills(id);
}

public List<Bills> findRent(UUID id) {
    return billsRepository.findRent(id);
}
// start
public List<Bills> findMortgage(UUID id) {
    return billsRepository.findMortgage(id);
}

public List<Bills> findMortgageEndowment(UUID id) {
    return billsRepository.findMortgageEndowment(id);
}

public List<Bills> findCouncilTax(UUID id) {
    return billsRepository.findCouncilTax(id);
}

public List<Bills> findInsurance(UUID id) {
    return billsRepository.findInsurance(id);
}

public List<Bills> findUtilities(UUID id) {
    return billsRepository.findUtilities(id);
}

public List<Bills> findGroceries(UUID id) {
    return billsRepository.findGroceries(id);
}

public List<Bills> findByFrequency(String frequency) {
    return billsRepository.findByFrequency(frequency);
}



public Bills createBills(Bills bills)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return billsRepository.save(bills);
}

Bills updateBills(UUID id, Bills updatedBills) 
    throws NoSuchElementException, IllegalArgumentException{
    Bills bills = billsRepository.findById(id).orElseThrow();

    bills.setuser(updatedBills.getUser());
    bills.setRent(updatedBills.getRent()!= null ? updatedBills.getRent() : BigDecimal.ZERO);
    bills.setMortgage(updatedBills.getMortgage()!= null ? updatedBills.getMortgage() : BigDecimal.ZERO);
    bills.setMortgageEndowment(updatedBills.getMortgageEndowment()!= null ? updatedBills.getMortgageEndowment() : BigDecimal.ZERO);
    bills.setCouncilTax(updatedBills.getCouncilTax()!= null ? updatedBills.getCouncilTax() : BigDecimal.ZERO);
    bills.setInsurance(updatedBills.getInsurance()!= null ? updatedBills.getInsurance() : BigDecimal.ZERO);
    bills.setUtilities(updatedBills.getUtilities()!= null ? updatedBills.getUtilities() : BigDecimal.ZERO);
    bills.setGroceries(updatedBills.getGroceries()!= null ? updatedBills.getGroceries() : BigDecimal.ZERO);
    bills.setFrequency(updatedBills.getFrequency());

    return billsRepository.save(updatedBills);
       
    }
    public void deleteBillsById(UUID id){
        if(!billsRepository.existsById(id)){
            throw new NoSuchElementException("Bill Not Found");
        }
            billsRepository.deleteById(id);
    }
    }
    




