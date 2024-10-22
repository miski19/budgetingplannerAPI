package com.cbfacademy.apiassessment.Bills;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface BillsRepository extends ListCrudRepository<Bills, UUID> {


List<User> searchById(UUID id);;
List<Bills> findBills(UUID id);
List<Bills> findRent(UUID id);
List<Bills> findMortgage(UUID id);
List<Bills> findMortgageEndowment(UUID id);
List<Bills> findCouncilTax(UUID id);
List<Bills> findInsurance(UUID id);
List<Bills> findUtilities(UUID id);
List<Bills> findGroceries(UUID id);
List<Bills> findByFrequency(String frequency);


}
