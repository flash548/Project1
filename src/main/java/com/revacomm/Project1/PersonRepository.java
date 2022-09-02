package com.revacomm.Project1;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByFirstNameIgnoreCase(String firstName);
    List<Person> findByLastNameIgnoreCase(String lastName);
}