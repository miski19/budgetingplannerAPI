package com.cbfacademy.apiassessment.Income;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface IncomeRepository extends ListCrudRepository<Income, UUID>{

 
 List<User> searchById(UUID id);
 List<Income> findIncome(UUID id);
 List<Income> findSalaryAfterTaxes(UUID id);
 List<Income> findSelfEmploymentIncome(UUID id);
 List<Income>findStatutorySickPay(UUID id);
 List<Income> findStatutoryMaternityPay(UUID id);
 List<Income> findByFrequency(String frequency);
}
