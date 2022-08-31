package com.revacomm.Project1;

import java.util.List;
import java.util.Optional;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("personService")
@NoArgsConstructor
public class PersonService {
    @Autowired
    private PersonRepository personRepo;

    public void test2(){
        System.out.println("... TRIGGER ...");
    }

    public Object getAllEmployees(){
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

    public Object findByLastName(String lastName){
        return(personRepo.findByLastName(lastName));
    }

    public void test() {
        // Save a new person
        System.out.println("Triggered PersonService");
        Person newPerson = new Person(12372, "John", "Mayer", 42);
        personRepo.save(newPerson);

        // Find a person by ID
        Optional<Person> result = personRepo.findById(201010);
        result.ifPresent(person -> System.out.println(person));

        // Find people by last name
        List<Person> people = personRepo.findByLastName("Smith");
        people.forEach(person -> System.out.println(person));

        // List all people
        Iterable<Person> iterator = personRepo.findAll();
        iterator.forEach(person -> System.out.println(person));

        // Count number of people
        long count = personRepo.count();
        System.out.println("Number of people: " + count);
    }
}