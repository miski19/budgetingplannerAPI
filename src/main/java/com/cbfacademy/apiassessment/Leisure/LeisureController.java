package com.cbfacademy.apiassessment.Leisure;

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
@RequestMapping("/leisure")
public class LeisureController {
LeisureService leisureService;

public LeisureController (LeisureService leisureService) {
    this.leisureService = leisureService;
}

@GetMapping("/{id}")
    public List<Leisure> getLeisure(@PathVariable UUID id)throws NoSuchElementException  {
        return leisureService.findLeisure(id);
    }

//start
@GetMapping("entertainment/{id}")
public List<Leisure> getEntertainment(@PathVariable UUID id)throws NoSuchElementException  {
        return leisureService.findEntertainment(id);
    }

@GetMapping("dining-out/{id}")
public List<Leisure> getDiningOut(@PathVariable UUID id)throws NoSuchElementException  {
        return leisureService.findDiningOut(id);
    }

@GetMapping("travel/{id}")
public List<Leisure> getTravel(@PathVariable UUID id, @RequestBody Leisure leisure)throws NoSuchElementException  {
        return leisureService.findTravel(id);
    }

@GetMapping("sports-membership/{id}")
public List<Leisure> getSportsMembership(@PathVariable UUID id, @RequestBody Leisure leisure)throws NoSuchElementException  {
        return leisureService.findSportsMembership(id);
    }


@GetMapping("frequency/{id}")
public List<Leisure> getFrequency(String frequency) throws NoSuchElementException{
        return leisureService.findByFrequency(frequency);
}
                
 @PostMapping("/{id}")
    public ResponseEntity<Leisure> createLeisure (@RequestBody Leisure leisure) {
        try {
            Leisure createdLeisure= leisureService.createLeisure(leisure);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLeisure);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leisure> updateLeisure(@PathVariable UUID id, @RequestBody Leisure leisure) {
        try {
            Leisure updatedLeisure = leisureService.updateLeisure(id, leisure);
            return ResponseEntity.ok(updatedLeisure);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leisure not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLeisure(@PathVariable UUID id) {
        try {
            leisureService.deleteLeisureById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leisure not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }
}
