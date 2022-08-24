package com.example.restservice;

public class Person {

    // Class attributes
    private final int id;
    private final String firstName;
    private final String lastName;
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

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}