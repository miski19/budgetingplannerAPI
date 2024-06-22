package com.cbfacademy.apiassessment.Pensions;

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
@RequestMapping("/pensions")
public class PensionsController {
PensionsService pensionsService;

public PensionsController(PensionsService pensionsService) {
    this.pensionsService = pensionsService;
}

@GetMapping("/{id}")
public List<Pensions> getAllPensionsById(@PathVariable UUID id, @RequestBody Pensions pensions) throws NoSuchElementException{
        return pensionsService.getAllPensionsById(id);
}

@GetMapping("/{id}")
    public List<Pensions> getPensionsById(@PathVariable UUID id, @RequestBody Pensions pensions) throws NoSuchElementException {
        return pensionsService.getPensionsById(id);              
}

@GetMapping("/{id}")
    public List<Pensions> getStatePensionById(@PathVariable UUID id, @RequestBody Pensions pensions) throws NoSuchElementException {
        return pensionsService.getStatePensionById(id);              
}

@GetMapping("/{id}")
    public List<Pensions> getPrivatePensionById(@PathVariable UUID id, @RequestBody Pensions pensions) throws NoSuchElementException {
        return pensionsService.getPrivatePensionById(id);              
}
@GetMapping
public List<Pensions> getFrequency() throws NoSuchElementException{
        return pensionsService.getFrequency();
}

 @PostMapping
    public ResponseEntity<Pensions> createPension (@RequestBody Pensions pensions) {
        try {
            Pensions createdPensions = pensionsService.createPensions(pensions);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPensions);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pensions> updatePensions(@PathVariable UUID id, @RequestBody Pensions pensions) {
        try {
            Pensions updatedPensions = pensionsService.updatePensions(id, pensions);
            return ResponseEntity.ok(updatedPensions);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pension not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePensions(@PathVariable UUID id) {
        try {
            pensionsService.deletePensionsById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pension not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }
}
