

package com.school;

public class Main {
    public static void main(String[] args) {
        FileStorageService fileStorageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(fileStorageService);
        AttendanceService attendanceService = new AttendanceService(fileStorageService, registrationService);

        // Register entities
        Student s1 = new Student(1, "Alice", "CS");
        Student s2 = new Student(2, "Bob", "Math");
        Teacher t1 = new Teacher(1, "Dr. Sharma", "Physics");
        Staff st1 = new Staff(1, "Rajesh", "Admin");

        Course c1 = new Course(1, "Java Fundamentals", t1);

        registrationService.registerStudent(s1);
        registrationService.registerStudent(s2);
        registrationService.registerTeacher(t1);
        registrationService.registerStaff(st1);
        registrationService.createCourse(c1);

        // Mark attendance
        attendanceService.markAttendance(1, 1, "Present");
        attendanceService.markAttendance(2, 1, "Absent");

        // Display directory
        System.out.println("\nSchool Directory:");
        for (Person p : registrationService.getAllPeople()) {
            System.out.println(p);
        }

        // Save data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ Data saved successfully!");
    }
}
