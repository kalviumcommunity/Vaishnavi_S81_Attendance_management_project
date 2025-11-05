package com.school;

public class Teacher extends Person implements Storable {
    private String subject;

    public Teacher(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Subject: " + subject + " (Role: Teacher)");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + subject;
    }

    @Override
    public String toString() {
        return "Teacher{id=" + id + ", name='" + name + "', subject='" + subject + "'}";
    }
}
