package com.cbfacademy.apiassessment.Pensions;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface PensionsRepository extends ListCrudRepository<Pensions, UUID> {


List<User> searchById(UUID id);
List<Pensions> findPensions(UUID id);
List<Pensions> findStatePension(UUID id);
List<Pensions> findPrivatePension(UUID id);
List<Pensions> findByFrequency(String frequency);
}
