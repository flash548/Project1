// What even does this line do?
package com.example.restservice;

// Is this necessary? Copy pasted https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByLastName(String lastName);
}