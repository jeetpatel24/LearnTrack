package com.airtribe.learntrack.entity;

// class is abstract, so that nobody can create an object of Person,
// as no Person can exist, Person can exist in the form of Student or a Trainer
public abstract class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    Person(int id, String firstName, String lastName,  String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
