// package com.school;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Create Students
//         Student s1 = new Student("abc");
//         Student s2 = new Student("xzy");

//         // Create Courses
//         Course c1 = new Course("Java");
//         Course c2 = new Course("Python");

//         // Display Students
//         s1.displayDetails();
//         s2.displayDetails();

//         // Display Courses
//         c1.displayDetails();
//         c2.displayDetails();

//         // Create Attendance Log
//         List<AttendanceRecord> attendanceLog = new ArrayList<>();
//         attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
//         attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c1.getCourseId(), "Absent"));
//         attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late")); // invalid

//         // Display Attendance Records
//         for (AttendanceRecord record : attendanceLog) {
//             record.displayRecord();
//         }

//         sc.close();
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Student student = new Student("Alice", "10th Grade");
//         Teacher teacher = new Teacher("Mr. Smith", "Mathematics");
//         Staff staff = new Staff("John", "Librarian");

//         student.displayDetails();
//         System.out.println("Student ID (for attendance): " + student.getId());

//         teacher.displayDetails();
//         staff.displayDetails();
//     }
// }

package com.school;

import java.util.*;

public class Main {

    // Polymorphic directory display
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person person : people) {
            person.displayDetails(); // Polymorphic call
        }
    }

    public static void main(String[] args) {

        // ===== Create Students =====
        Student s1 = new Student("Alice", "Computer Science");
        Student s2 = new Student("Bob", "Mathematics");

        // ===== Create Teacher =====
        Teacher t1 = new Teacher("Dr. Smith", "Computer Science");

        // ===== Create Staff =====
        Staff staff1 = new Staff("Mr. Johnson", "Administration");

        // ===== Create Course =====
        Course c1 = new Course("OOP with Java");

        // ===== Create Attendance Records =====
        AttendanceRecord ar1 = new AttendanceRecord(s1, c1, "Present");
        AttendanceRecord ar2 = new AttendanceRecord(s2, c1, "Absent");

        // ===== Display Attendance =====
        System.out.println("=== Attendance Log ===");
        ar1.displayRecord();
        ar2.displayRecord();

        // ===== Build School Directory =====
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(t1);
        schoolPeople.add(staff1);

        // ===== Show Polymorphism =====
        displaySchoolDirectory(schoolPeople);

        // ===== Optional: Save Students (if FileStorageService exists) =====
        /*
        List<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }
        FileStorageService.saveData(students, "students.txt");
        */
    }
}
