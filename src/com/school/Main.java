package com.school;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create storage and services
        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // --- Register people ---
        Student s1 = new Student(1, "Alice", "Computer Science");
        Student s2 = new Student(2, "Bob", "Mathematics");
        Student s3 = new Student(3, "Charlie", "Physics");

        Teacher t1 = new Teacher(11, "Dr. Smith", "Computer Science");
        Staff st1 = new Staff(21, "Mr. Johnson", "Administration");

        regService.registerStudent(s1);
        regService.registerStudent(s2);
        regService.registerStudent(s3);

        regService.registerTeacher(t1);
        regService.registerStaff(st1);

        // --- Create courses with capacities ---
        Course c1 = new Course(101, "OOP with Java", 2); // capacity 2
        Course c2 = new Course(102, "Database Systems", 3); // capacity 3

        regService.createCourse(c1);
        regService.createCourse(c2);

        // --- Enroll students (including an attempt that exceeds capacity) ---
        regService.enrollStudentInCourse(s1, c1); // should succeed
        regService.enrollStudentInCourse(s2, c1); // should succeed
        regService.enrollStudentInCourse(s3, c1); // should fail (capacity reached)

        regService.enrollStudentInCourse(s3, c2); // should succeed

        // Display courses details to show capacity and enrollment
        System.out.println("\n=== Course Details After Enrollment ===");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
            System.out.println();
        }

        // --- Mark attendance (optionally check enrollment before marking) ---
        // We'll mark presence only if student is enrolled in that course
        // Using ID-based markAttendance which uses RegistrationService lookups
        attendanceService.markAttendance(1, 101, "Present"); // Alice in OOP
        attendanceService.markAttendance(2, 101, "Absent");  // Bob in OOP
        attendanceService.markAttendance(3, 101, "Present"); // Charlie not enrolled -> still will mark, but ideally you'd check

        // Optionally: only mark if enrolled
        // Example check:
        if (c2.getEnrolledStudents().stream().anyMatch(s -> s.getId() == 3)) {
            attendanceService.markAttendance(3, 102, "Present"); // Charlie in Database Systems
        }

        // --- Display polymorphic school directory ---
        displaySchoolDirectory(regService);

        // --- Display attendance logs (all and filtered) ---
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(s1); // Alice
        attendanceService.displayAttendanceLog(c2); // Database Systems

        // --- Save data to files ---
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ Completed Part 10 run. Check the generated .txt files in your project folder.");
    }

    // Display directory using RegistrationService (polymorphic)
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== School Directory ===");
        List<Person> people = regService.getAllPeople();
        for (Person p : people) {
            p.displayDetails();
            System.out.println();
        }
    }
}
