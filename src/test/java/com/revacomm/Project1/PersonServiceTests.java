package com.revacomm.Project1;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {
    // Mock not Mock Bean because Beans are specific to spring
    // Bean is a service, a rest controller, etc. and we don't need that overhead here since we're just testing
    // a java class not a spring thing
    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    void testGetAllEmployees(){
        Mockito.when(personRepository.findAll()).thenReturn(Lists.newArrayList(Person.builder()
                .firstName("McCoy")
                .lastName("Doherty")
                .age(25)
                .build()
        ));
        assertEquals(1, Lists.newArrayList(personService.getAllEmployees()).size());
    }

    // https://mkyong.com/spring-boot/mockito-how-to-mock-repository-findbyid-thenreturn-optional/
    // " no suitable method found for thenReturn ...
    // method org.mockito.stubbing.OngoingStubbing.thenReturn is not applicable"
    @Test
    void testGetEmployeeByID(){
        Mockito.when(personRepository.findById(anyInt())).thenReturn(Optional.of(Person.builder()
                .firstName("McCoy")
                .lastName("Doherty")
                .age(25)
                .build()
        ));
        assertEquals(1, Lists.newArrayList(personService.getEmployeeByID(anyInt())).size());
        assertEquals(1, Lists.newArrayList(personService.getEmployeeByID(27)).size());
    }

    // whoops purge this, written pretty wrong
    @Test
    void testCreatePerson(){
        // Test that you can create a new person and get back the right HTTP code
        // Test that you can't create a duplicate of a person that exists

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(Person.builder()
                .firstName("McTest")
                .lastName("Testerman")
                .age(25)
                .build()
        );

        Person testGuy = new Person("McTest", "Testerman",25);
        assert(testGuy.equals(personService.createPerson(new Person("McTest","Testerman",25))));
    }

}
