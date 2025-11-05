package com.school;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // Create students
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Alice", "Computer Science"));
        allStudents.add(new Student(2, "Bob", "Mathematics"));
        allStudents.add(new Student(3, "Charlie", "Physics"));

        // Create courses
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(new Course(101, "OOP with Java"));
        allCourses.add(new Course(102, "Data Structures"));

        // ✅ Mark attendance (using object references)
        attendanceService.markAttendance(allStudents.get(0), allCourses.get(0), "Present");
        attendanceService.markAttendance(allStudents.get(1), allCourses.get(1), "Absent");

        // ✅ Mark attendance (using IDs)
        attendanceService.markAttendance(3, 102, "Present", allStudents, allCourses);

        // ✅ Display logs
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(allStudents.get(0));
        attendanceService.displayAttendanceLog(allCourses.get(1));

        // ✅ Save to file
        attendanceService.saveAttendanceData();
    }
}
