package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person {
    private int batch;
    private boolean active;

    // constructor
    public Student(String firstName, String lastName, String email, int batch, boolean active) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    // constructor - Student without email
    public Student(String firstName, String lastName, int batch, boolean active) {
        this(firstName, lastName, null, batch, active);
    }

    // overridden method
    @Override
    public String getDisplayName() {
        return "Student: " + getFirstName() + " " + getLastName();
    }

    // Getters and setters
    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String emailText = (getEmail() == null) ? "N/A" : getEmail();
        return "ID: " + getId()
                + " | Name: " + getFirstName() + " " + getLastName()
                + " | Email: " + emailText
                + " | Batch: " + batch
                + " | Active: " + active;
    }
}
