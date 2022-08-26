package com.revacomm.Project1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public void test() {
        // Save a new person
        System.out.println("Triggered PersonService");
        Person newPerson = new Person(12372, "John", "Mayer", 42);
        repository.save(newPerson);

        // Find a person by ID
        Optional<Person> result = repository.findById(201010);
        result.ifPresent(person -> System.out.println(person));

        // Find people by last name
        List<Person> people = repository.findByLastName("Smith");
        people.forEach(person -> System.out.println(person));

        // List all people
        Iterable<Person> iterator = repository.findAll();
        iterator.forEach(person -> System.out.println(person));

        // Count number of people
        long count = repository.count();
        System.out.println("Number of people: " + count);
    }
}