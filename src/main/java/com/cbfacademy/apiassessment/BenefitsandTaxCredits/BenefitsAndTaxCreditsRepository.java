package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface BenefitsAndTaxCreditsRepository extends ListCrudRepository<BenefitsAndTaxCredits, UUID> {

List<User> searchById(UUID id);
List<BenefitsAndTaxCredits> findBenefitsAndTaxCredits(UUID id);
List<BenefitsAndTaxCredits> findJobSeekersAllowance(UUID id);
List<BenefitsAndTaxCredits> findWorkingTaxCredit(UUID id);
List<BenefitsAndTaxCredits> findChildTaxCredit(UUID id);
List<BenefitsAndTaxCredits> findChildBenefit(UUID id);
List<BenefitsAndTaxCredits> findEmploymentSupportAllowance(UUID id);
List<BenefitsAndTaxCredits> findUniversalCredit(UUID id);
List<BenefitsAndTaxCredits> findDisabilityAllowance(UUID id);
List<BenefitsAndTaxCredits> findAttendanceAllowance(UUID id);
List<BenefitsAndTaxCredits> findCarersAllowance(UUID id);
List<BenefitsAndTaxCredits> findHousingBenefit(UUID id);
List<BenefitsAndTaxCredits> findMaternityAllowance(UUID id);
List<BenefitsAndTaxCredits> findByFrequency(String frequency);

}
