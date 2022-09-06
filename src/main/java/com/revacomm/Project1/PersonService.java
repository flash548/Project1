package com.revacomm.Project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revacomm.Project1.exception.RecordAlreadyExistsException;
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

    public Iterable<Person> getAllEmployees(){
        return personRepo.findAll();
    }

    public Object getEmployeeByID(int id){
        return personRepo.findById(id);
    }

    public Person createPerson(Person requestedPerson){
        String firstName = requestedPerson.getFirstName();
        String lastName = requestedPerson.getLastName();

        List<Person> lastNameMatches = personRepo.findByLastNameIgnoreCase(lastName);

        // IF :: any records have a matching last name
        if(lastNameMatches.size() > 0){
            lastNameMatches.forEach(each -> {
                // THEN :: ensure they don't also have the same first name
                if(each.getFirstName().toLowerCase().equals(firstName.toLowerCase())){
                    // If they do, throw exception
                    throw new RecordAlreadyExistsException("Record Already Found Matching First Name + Last Name");
                }
            });
        }

        personRepo.save(requestedPerson);
        return(requestedPerson);
    }

    public Person updatePerson(Person requestedPerson){
        Person updatedPerson = personRepo.save(requestedPerson);
        return requestedPerson;
    }

    public boolean deletePerson(int id){
        try{
            // could also be .deleteAllById()
            personRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Object findByFirstName(String firstName){
        return(personRepo.findByFirstNameIgnoreCase(firstName));
    }

    public Object findByLastName(String lastName){
        return(personRepo.findByLastNameIgnoreCase(lastName));
    }

}