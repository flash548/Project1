package com.revacomm.Project1;

// Handles... routing and request parameter handling
import com.revacomm.Project1.exception.RecordAlreadyExistsException;
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

import java.util.List;

/*
  To-Do List
    - Shift DB create // delete code elsewhere then drop the personRepo import
    - Testing
*/

@RestController
public class PersonController {
    // Almost ready to drop this as things have migrated to service, only used in DB build/teardown
    // Shift to service and / or go and make it a startup function
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    // Returns all records
    @GetMapping("/person")
    public Object getAllEmployees(){
        return personService.getAllEmployees();
    }

    // Returns all records matching ID parameter from path
    @GetMapping("/person/{id}")
    public Object getPerson(@PathVariable int id){
        return personService.getEmployeeByID(id);
    }

    // Create Person
    // Note :: Pass parameters via JSON in PostMan to test this, but not path variables like before
    @PostMapping("/person/")
    public ResponseEntity<Person> createPerson(@RequestBody Person requestedPerson){
        return personService.createPerson(requestedPerson);
    }

    // Update Person
    // PUT :: you pass the whole object to overwrite whatever exists, but via PATCH w/ a JSON patch-map
    //        one can also optionally add support for partial-overwrite, leaving other prior field data alone
    // Note :: Pass parameters via JSON in Postman to test like the above one, but now including ID
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person requestedPerson){
        try{
            return personService.updatePerson(requestedPerson);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Person
    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        return personService.deletePerson(id);
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

        Person mortE = new Person("Mortimer E.", "Cheese", 45);
        personRepository.save(mortE);

        Person chester = new Person("Chester", "Cheese", 37);
        personRepository.save(chester);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/db")
    public ResponseEntity depopulateDB(){
        personRepository.deleteAll();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/person/getByFirstName/{firstName}")
    public Object getByFirstName(@PathVariable String firstName) {
        System.out.println(firstName);
        return personService.findByFirstName(firstName);
    }

    @GetMapping("/person/getByLastName/{lastName}")
    public Object getByLastName(@PathVariable String lastName) {
        System.out.println(lastName);
        return personService.findByLastName(lastName);
    }
}

