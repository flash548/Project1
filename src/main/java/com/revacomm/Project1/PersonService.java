package com.revacomm.Project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// ToDo :: add prevention of duplication of first-last name sets

@Service("personService")
@NoArgsConstructor
public class PersonService {
    @Autowired
    private PersonRepository personRepo;

    public Iterable<Person> getAllEmployees(){
        return personRepo.findAll();
    }

    public Object getEmployeeByID(int id){
        return personRepo.findById(id);
    }

    public ResponseEntity<Person> createPerson(Person requestedPerson){
        Person newPerson = personRepo.save(requestedPerson);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    public ResponseEntity<Person> updatePerson(Person requestedPerson){
        Person updatedPerson = personRepo.save(requestedPerson);
        return new ResponseEntity<>(updatedPerson, HttpStatus.ACCEPTED);
    }

    public ResponseEntity deletePerson(int id){
        try{
            // could also be .deleteAllById()
            personRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Object findByFirstName(String firstName){
        return(personRepo.findByFirstNameIgnoreCase(firstName));
    }

    public Object findByLastName(String lastName){
        return(personRepo.findByLastNameIgnoreCase(lastName));
    }

}