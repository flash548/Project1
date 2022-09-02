package com.revacomm.Project1;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
