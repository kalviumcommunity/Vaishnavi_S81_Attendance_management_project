package com.school;

public class Student implements Storable {
    private int studentId;
    private String name;
    private String gradeLevel;

    public Student(int studentId, String name, String gradeLevel) {
        this.studentId = studentId;
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getGradeLevel() { return gradeLevel; }

    @Override
    public String toDataString() {
        return studentId + "," + name + "," + gradeLevel;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId + ", Name: " + name + ", Grade Level: " + gradeLevel);
    }
}
