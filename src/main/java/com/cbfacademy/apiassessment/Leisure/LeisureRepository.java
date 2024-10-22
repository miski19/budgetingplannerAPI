package com.cbfacademy.apiassessment.Leisure;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface LeisureRepository extends ListCrudRepository<Leisure, UUID> {

List<User> searchById(UUID id);
List<Leisure> findLeisure(UUID id);
List<Leisure> findEntertainment(UUID id);
List<Leisure> findDiningOut(UUID id);
List<Leisure> findTravel(UUID id);
List<Leisure> findSportsMembership(UUID id);
List<Leisure> findByFrequency(String frequency);
}
