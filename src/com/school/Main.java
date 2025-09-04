package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Students
        Student s1 = new Student("abc");
        Student s2 = new Student("xzy");

        // Create Courses
        Course c1 = new Course("Java");
        Course c2 = new Course("Python");

        // Display Students
        s1.displayDetails();
        s2.displayDetails();

        // Display Courses
        c1.displayDetails();
        c2.displayDetails();

        // Create Attendance Log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c1.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late")); // invalid

        // Display Attendance Records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        sc.close();
    }
}
