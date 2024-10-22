package com.cbfacademy.apiassessment.OtherIncome;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface OtherIncomeRepository extends ListCrudRepository<OtherIncome, UUID> {
    
List<User> searchById(UUID id);
List<OtherIncome> findOtherIncome(UUID id);
List<OtherIncome> findRentalIncome(UUID id);
List<OtherIncome> findInvestmentIncome(UUID id);
List<OtherIncome> findByFrequency(String frequency);

}
