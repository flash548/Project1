package com.revacomm.Project1;

// Handles... routing and request parameter handling
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Handles... get-post-put-delete
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;

/*
  To-Do List
    - Migrate the repository calls controller --> service
    - Consider if there's a way to make update use original value in cases where not all params provided
*/

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    // Returns all records
    @GetMapping("/person")
    public Object getAllEmployees() {
        return personRepository.findAll();
    }

    // Returns all records matching ID parameter from path
    @GetMapping("/person/{id}")
    public Object getPerson(@PathVariable int id){
        return personRepository.findById(id);
    }

    // Create Person
    // Note :: Pass parameters via JSON in PostMan to test this, but not path variables like before
    @PostMapping("/person/")
    public ResponseEntity<Person> createPerson(@RequestBody Person requestedPerson){
        //System.out.println(requestedPerson);
        Person newPerson = personRepository.save(requestedPerson);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    // Update Person
    // This works, but is there a way to make defaultValue=OriginalValue ?
    // Note :: Pass parameters via JSON in Postman to test like the above one, but now including ID
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person requestedPerson){
        try{
            Person updatedPerson = personRepository.save(requestedPerson);
            return new ResponseEntity<>(updatedPerson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Person
    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        // could also be .deleteAllById()
        try {
            personRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/db")
    public ResponseEntity populateDB(){
        Person mattNath = new Person("Matt", "Nathanson", 49);
        personRepository.save(mattNath);

        Person johnAmerica = new Person("John", "America", 245);
        personRepository.save(johnAmerica);

        Person bowie = new Person("David", "Bowie", 69);
        personRepository.save(bowie);

        Person chuckE = new Person("Chuck E.", "Cheese", 45);
        personRepository.save(chuckE);

        Person appleseed = new Person("Kakashi", "Hatake", 37);
        personRepository.save(appleseed);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/db")
    public ResponseEntity depopulateDB(){
        personRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // ... Beyond Scope Code Below ... Retained for Reference ...

    // Get records by last name (not required by spec, just wanted to try writing an interface + use String parameter
    @GetMapping("/personByLastName/{LastName}")
    public Object tryGetID(@PathVariable String LastName) {
        return personRepository.findByLastName(LastName);
    }

    @GetMapping("/personTemp")
    // This request-param annotation
    public Person getPerson(@RequestParam(value="firstName", defaultValue="defaultFirst") String firstName) {
        return new Person(1, firstName, "Doherty", 25);
    }
}

