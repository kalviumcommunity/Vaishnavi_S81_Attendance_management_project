package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "Grade 10"));
        students.add(new Student(2, "Bob", "Grade 11"));

        // Courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(101, "Mathematics"));
        courses.add(new Course(102, "Science"));

        // Attendance Records
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(1, 101, "Present"));
        records.add(new AttendanceRecord(2, 101, "Absent"));
        records.add(new AttendanceRecord(1, 102, "Late")); // Invalid test

        // File Storage
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nCheck the text files for saved data.");
    }
}
