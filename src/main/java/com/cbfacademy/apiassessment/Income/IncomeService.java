package com.cbfacademy.apiassessment.Income;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;



@Service
public class IncomeService {
public IncomeRepository incomeRepository;

public IncomeService(IncomeRepository incomeRepository) {
    this.incomeRepository = incomeRepository;
}

public List<Income> findIncome(UUID id) throws NoSuchElementException {
    return incomeRepository.findIncome(id);
}

public List<Income> findSalaryAfterTaxes(UUID id)throws NoSuchElementException {
    return incomeRepository.findSalaryAfterTaxes(id);
}

public List<Income> findSelfEmploymentIncome(UUID id)throws NoSuchElementException {
    return incomeRepository.findSelfEmploymentIncome(id);
}

public List<Income>findStatutorySickPay(UUID id)throws NoSuchElementException {
    return incomeRepository.findStatutorySickPay(id);
}

public List<Income> findStatutoryMaternityPay(UUID id)throws NoSuchElementException {
    return incomeRepository.findStatutoryMaternityPay(id);
}


public List<Income> findByFrequency(String frequency) {
    return incomeRepository.findByFrequency(frequency);
}

public Income createIncome(Income income)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return incomeRepository.save(income);
}

Income updateIncome(UUID id, Income updatedIncome) throws NoSuchElementException, IllegalArgumentException{
   
    updatedIncome.setUser(updatedIncome.getUser());
    updatedIncome.setSalaryAfterTaxes(updatedIncome.getSalaryAfterTaxes()!= null ? updatedIncome.getSalaryAfterTaxes() : BigDecimal.ZERO);
    updatedIncome.setSelfEmploymentIncome(updatedIncome.getSelfEmploymentIncome()!= null ? updatedIncome.getSelfEmploymentIncome() : BigDecimal.ZERO);
    updatedIncome.setStatutorySickPay(updatedIncome.getStatutorySickPay()!= null ? updatedIncome.getStatutorySickPay() : BigDecimal.ZERO);
    updatedIncome.setStatutoryMaternityPay(updatedIncome.getStatutoryMaternityPay()!= null ? updatedIncome.getStatutoryMaternityPay() : BigDecimal.ZERO);
    updatedIncome.setFrequency(updatedIncome.getFrequency());

    return incomeRepository.save(updatedIncome);
       
    
       }

        public void deleteIncomeById(UUID id){
            if(!incomeRepository.existsById(id)){
                throw new NoSuchElementException("Income Not Found");
            }
                incomeRepository.deleteById(id);
        }

}

    
    


