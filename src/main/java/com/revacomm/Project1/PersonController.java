// Seems to designate path
package com.revacomm.Project1;

// This... seems to auto increment? Look into it for more detail
import java.util.concurrent.atomic.AtomicLong;

// Handles... routing and request parameter handling?
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Imports for get-post-put-delete
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Allows us to take in path variable, so /person/{somevalue}
import org.springframework.web.bind.annotation.PathVariable;

// from https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getAllEmployees")
    public Object getAllEmployees() {
        return personRepository.findAll();
    }

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

    @GetMapping("/test")
    public void testFunction(Person person){
        System.out.println("Test Route Triggered");


        //List<Person> listPeople = personRepo.findAll();
        //person.addAttribute("listPeople", listPeople);

        // from https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
        /*
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.example.restservice;");
        appContext.refresh();
        PersonService personService = (PersonService) appContext.getBean("personService");
        personService.test();
         */

    }

    @GetMapping("/test2")
    public Person testFunction2(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","mccoy", "");
            System.out.println("WOO");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM person;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age  = rs.getInt("age");

                System.out.println( "ID = " + id );
                System.out.println( "Last Name = " + firstName );
                System.out.println( "First Name = " + lastName );
                System.out.println( "Age = " + age );
                System.out.println();
            }

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

        Person johnLennon = new Person(22, "John", "Lennon", 55);
        System.out.println(johnLennon);
        return johnLennon;
    }
}

