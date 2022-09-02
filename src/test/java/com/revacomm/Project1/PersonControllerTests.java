package com.revacomm.Project1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PersonControllerTests {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @Test
    void testGetAll() throws Exception {
        Mockito.when(personService.getAllEmployees()).thenReturn(Lists.newArrayList(Person.builder()
                .firstName("McCoy")
                .lastName("Doherty")
                .age(25)
                .build()
        ));
        MvcResult result = mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andReturn();
        Person[] personList = mapper.readValue(result.getResponse().getContentAsString(), Person[].class);
        assertEquals(1, personList.length);
    }
}
