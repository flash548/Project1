// What does this do? Copy pasta
package com.example.restservice;

// What does this do? Copy pasta
import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    // Class attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    private String firstName;
    private String lastName;
    private final int age;

    // Constructor
    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getter Functions
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + this.getFirstName() + " " + this.getLastName() + " (age: " + this.getAge() + ", id: " + this.getId() + ")";
    }
}
