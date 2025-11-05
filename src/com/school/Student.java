package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(int id, String name, String gradeLevel) {
        super(id, name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() { return gradeLevel; }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Grade Level: " + gradeLevel + " (Role: Student)");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + gradeLevel;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gradeLevel='" + gradeLevel + "'}";
    }
}
