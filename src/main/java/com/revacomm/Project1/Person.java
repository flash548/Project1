package com.revacomm.Project1;

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

    public String toString() {
        return "Name: " + this.getFirstName() + " " + this.getLastName() + " (age: " + this.getAge() + ", id: " + this.getId() + ")";
    }
}
