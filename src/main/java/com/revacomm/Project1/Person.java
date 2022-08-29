// What does this do? Copy pasta
package com.revacomm.Project1;

// What does this do? Copy pasta
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    // Class attributes
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    // Constructor
    /*
    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    */

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
