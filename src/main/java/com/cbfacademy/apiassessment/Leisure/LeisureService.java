package com.cbfacademy.apiassessment.Leisure;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;




@Service
public class LeisureService {
public LeisureRepository leisureRepository;

public LeisureService(LeisureRepository leisureRepository){
        this.leisureRepository = leisureRepository;
}

public List<Leisure> findLeisure(UUID id) {
    return leisureRepository.findLeisure(id);
}

public List<Leisure> findEntertainment(UUID id) {
    return leisureRepository.findEntertainment(id);
}

public List<Leisure> findDiningOut(UUID id) {
    return leisureRepository.findDiningOut(id);
}

public List<Leisure> findTravel(UUID id) {
    return leisureRepository.findTravel(id);
}

public List<Leisure> findSportsMembership(UUID id) {
    return leisureRepository.findSportsMembership(id);
}

public List<Leisure> findByFrequency(String frequency) {
    return leisureRepository.findByFrequency(frequency);
}

public Leisure createLeisure(Leisure leisure)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    return leisureRepository.save(leisure);
}

Leisure updateLeisure(UUID id, Leisure updatedLeisure)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    Leisure leisure = leisureRepository.findById(id).orElseThrow();

    leisure.setuser(updatedLeisure.getUser());  
    leisure.setDiningOut(updatedLeisure.getDiningOut()!= null ? updatedLeisure.getDiningOut() : BigDecimal.ZERO);
    leisure.setTravel(updatedLeisure.getTravel()!= null ? updatedLeisure.getTravel() : BigDecimal.ZERO);
    leisure.setSportsMembership(updatedLeisure.getSportsMembership()!= null ? updatedLeisure.getSportsMembership() : BigDecimal.ZERO);
    leisure.setFrequency(updatedLeisure.getFrequency());

return leisureRepository.save(updatedLeisure);


}

public void deleteLeisureById(UUID id){
    if(!leisureRepository.existsById(id)){
        throw new NoSuchElementException("Leisure Not Found");
    }
        leisureRepository.deleteById(id);
}
}
