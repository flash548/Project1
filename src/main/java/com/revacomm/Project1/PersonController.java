package com.revacomm.Project1;

// This... seems to auto increment? Look into it for more detail
import java.util.concurrent.atomic.AtomicLong;

// Handles... routing and request parameter handling
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Handles... get-post-put-delete
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Allows us to take in path variable, so /person/{somevalue}
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
    @PostMapping("/person/")
    public void createPerson(@RequestParam(value="firstName", defaultValue="FirstName") String firstName,
                             @RequestParam(value="lastName", defaultValue="LastName") String lastName,
                             @RequestParam(value="age", defaultValue="0") String age){
        Person TestDude = new Person(firstName, lastName, Integer.valueOf(age));
        personRepository.save(TestDude);
    }

    // Update Person
    // This works, but is there a way to make defaultValue=OriginalValue ?
    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable int id,
                               @RequestParam(value="firstName", defaultValue="FirstName") String firstName,
                               @RequestParam(value="lastName", defaultValue="LastName") String lastName,
                               @RequestParam(value="age", defaultValue="0") String age){
        Person updatedPerson = new Person(id, firstName, lastName, Integer.valueOf(age));
        personRepository.save(updatedPerson);
    }

    // Delete Person
    // Swapped to void to avoid errors but is that kosher or should there be some sort of "receipt of deletion"
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id){
        // could also be .deleteAllById()
        personRepository.deleteById(id);
    }

    @PostMapping("/db")
    public void populateDB(){
        Person MattNath = new Person(1337, "Matt", "Nathanson", 49);
        personRepository.save(MattNath);

        Person America = new Person(1776, "John", "America", 245);
        personRepository.save(America);

        Person Sandler = new Person(2356, "Adam", "Sandler", 55);
        personRepository.save(Sandler);

        Person Bowie = new Person(4667, "David", "Bowie", 69);
        personRepository.save(Bowie);

        Person ChuckE = new Person(9898, "Chuck E.", "Cheese", 45);
        personRepository.save(ChuckE);

        Person Mozzarella = new Person(7366, "Mozzarella E.", "Cheese", 22);
        personRepository.save(Mozzarella);

        Person Appleseed = new Person(2039, "Johnny", "Appleseed", 17);
        personRepository.save(Appleseed);
    }

    @DeleteMapping("/db")
    public void depopulateDB(){
        personRepository.deleteAll();
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

