package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/benefitsAndTaxCredits")
public class BenefitsAndTaxCreditsController {
BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;

public BenefitsAndTaxCreditsController(BenefitsAndTaxCreditsService benefitsAndTaxCreditsService) {
    this.benefitsAndTaxCreditsService = benefitsAndTaxCreditsService;
}

    @GetMapping("/{id}")
    public List<BenefitsAndTaxCredits> findBenefitsAndTaxCredits(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findBenefitsAndTaxCredits(id);
    }

    @GetMapping("jobseekers-allowance/{id}")
    public List<BenefitsAndTaxCredits> findJobSeekersAllowance(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findJobSeekersAllowance(id);
    }

    @GetMapping("working-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> findWorkingTaxCredit(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findWorkingTaxCredit(id);
    }

    @GetMapping("child-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> findChildTaxCredit(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findChildTaxCredit(id);
    }
    

    @GetMapping("child-benefit/{id}")
    public List<BenefitsAndTaxCredits> findChildBenefit(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findChildBenefit(id);
    }

    @GetMapping("emplyomenet-support-allowance/{id}")
    public List<BenefitsAndTaxCredits> findEmploymentSupportAllowance(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findEmploymentSupportAllowance(id);
    }

    @GetMapping("universal-credit/{id}")
    public List<BenefitsAndTaxCredits> findUniversalCredit(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findUniversalCredit(id);
    }

    @GetMapping("disability-allowance/{id}")
    public List<BenefitsAndTaxCredits> findDisabilityAllowance(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findDisabilityAllowance(id);
    }

    @GetMapping("attendance-allowance/{id}")
    public List<BenefitsAndTaxCredits> findAttendanceAllowance(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findAttendanceAllowance(id);
    }


    @GetMapping("carers-allowance/{id}")
    public List<BenefitsAndTaxCredits> findCarersAllowance(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findCarersAllowance(id);
    }

    @GetMapping("housing-benefit/{id}")
    public List<BenefitsAndTaxCredits> findHousingBenefit(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findHousingBenefit(id);
    }


    @GetMapping("maternity-allowance/{id}")
    public List<BenefitsAndTaxCredits> findMaternityAllowance(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findMaternityAllowance(id);
    }
@GetMapping("frequency/{id}")
public List<BenefitsAndTaxCredits> findFrequency(@PathVariable UUID id, String frequency) throws NoSuchElementException{
        return benefitsAndTaxCreditsService.findFrequency(frequency);
}
               
 @PostMapping("/{id}")
    public ResponseEntity<BenefitsAndTaxCredits> createBenefitsAndTaxCredits(@RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits) {
        try {
            BenefitsAndTaxCredits createdBenefitsAndTaxCredits = benefitsAndTaxCreditsService.createBenefitsAndTaxCredits(benefitsAndTaxCredits);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBenefitsAndTaxCredits);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitsAndTaxCredits> updateBenefitsAndTaxCredits(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits) {
        try {
            BenefitsAndTaxCredits updatedBenefitsAndTaxCredits = benefitsAndTaxCreditsService.updateBenefitsAndTaxCredits(id, benefitsAndTaxCredits);
            return ResponseEntity.ok(updatedBenefitsAndTaxCredits);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benefit not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBenefitsAndTaxCredits(@PathVariable UUID id) {
        try {
            benefitsAndTaxCreditsService.deleteBenefitsAndTaxCredits(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benefit not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}
