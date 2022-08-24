// Seems to designate path
package com.example.restservice;

// This... seems to auto increment? Look into it for more detail
import java.util.concurrent.atomic.AtomicLong;

// Handles... routing and request parameter handling?
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Imports for get-post-put-delete
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Allows us to take in path variable, so /person/{somevalue}
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/person")
    // This request-param annotation
    public Person getPerson(@RequestParam(value="firstName", defaultValue="defaultFirst") String firstName) {
        return new Person(1, firstName, "Doherty", 25);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable int id){
        return new Person(id, "Tester", "McTestersen", 25);
    }

    // Should this be at a specific ID or just at /person then the ID gets assigned
    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id){
        return new Person(id, "Tester", "Who Is Updated", 25);
    }

    @PostMapping("/person/{id}")
    public Person createPerson(@PathVariable int id){
        return new Person(id, "Tester", "Who Is New", 25);
    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(@PathVariable int id){
        return new Person(id, "Deleted", "Deleterson", 0);
    }

}