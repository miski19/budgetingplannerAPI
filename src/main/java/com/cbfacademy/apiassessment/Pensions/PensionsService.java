package com.cbfacademy.apiassessment.Pensions;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;



@Service
public class PensionsService {
public PensionsRepository pensionsRepository;

public PensionsService(PensionsRepository pensionsRepository){
        this.pensionsRepository = pensionsRepository;
}

public List<Pensions> findPensions(UUID id) {
    return pensionsRepository.findPensions(id);
}


public List<Pensions> findStatePension(UUID id) {
    return pensionsRepository.findStatePension(id);
}


public List<Pensions> findPrivatePension(UUID id) {
    return pensionsRepository.findPensions(id);
}

public List<Pensions> findByFrequency(String frequency) {
    return pensionsRepository.findByFrequency(frequency);
}

public Pensions createPensions(Pensions pensions)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return pensionsRepository.save(pensions);
}

Pensions updatePensions(UUID id, Pensions updatedPensions)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    Pensions pensions = pensionsRepository.findById(id).orElseThrow();
        pensions.setuser(updatedPensions.getUser());
        pensions.setStatePension(updatedPensions.getStatePension()!= null ? updatedPensions.getStatePension() : BigDecimal.ZERO);
        pensions.setPrivatePension(updatedPensions.getPrivatePension()!= null ? updatedPensions.getStatePension() : BigDecimal.ZERO);
        pensions.setFrequency(updatedPensions.getFrequency());



    return pensionsRepository.save(updatedPensions);

    }

public void deletePensionsById(UUID id){
    if(!pensionsRepository.existsById(id)){
        throw new NoSuchElementException("Leisure Not Found");
    }
        pensionsRepository.deleteById(id);
}

}
