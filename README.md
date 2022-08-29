# SpringBoot Project1


## Part1

This is a repo that is templated out to use Java 11, SpringBoot, and PostgreSQL database.

Your task is to implement a very basic API that allows CRUD operations of "people" to the 
database (so get all people (GET), get a person by their UUID (GET), update a person by their UUID (PUT), add a new person (POST), and delete a person by their UUID (DELETE) ).

A few things to help:

    - Store the entities in a table called "person"
    - Make sure you use snake case for column names (e.g. first_name) just in the database
    - These CRUD endpoints should be under /person  (so a GET to /person would list all person entities in JSON)
    - The person entity fields should be id (a UUID), firstName, lastName, age
    - Design pattern should be endpoints in a PersonController class, business logic (e.g. database operations) in a PersonService class, and your entities in a PersonModel class
    - Unit tests for each of those three classes should be made

Before you start make sure you have some sort of Java development environment setup:

    - JDK 11 installed (OpenJDK, etc)
    - PostgreSQL installed
    - Apache Maven installed

Work together and ask for help!  Have fun!



