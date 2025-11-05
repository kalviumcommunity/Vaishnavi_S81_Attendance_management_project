package com.school;

import java.util.*;
import java.util.stream.Collectors;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overloaded 1: mark attendance using objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student.getId(), course.getCourseId(), status);
        attendanceLog.add(record);
        System.out.println("Marked attendance for " + student.getName() + " in " + course.getCourseName() + ": " + status);
    }

    // Overloaded 2: mark attendance using IDs
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("❌ Could not find Student or Course for IDs: " + studentId + ", " + courseId);
        }
    }

    // Helper: find student by ID
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Helper: find course by ID
    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // Display all records
    public void displayAttendanceLog() {
        System.out.println("\n=== Attendance Log (All Records) ===");
        for (AttendanceRecord record : attendanceLog) {
            System.out.println(record);
        }
    }

    // Display by student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance Log for Student: " + student.getName() + " ===");
        attendanceLog.stream()
                .filter(r -> r.getStudentId() == student.getId())
                .forEach(System.out::println);
    }

    // Display by course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance Log for Course: " + course.getCourseName() + " ===");
        attendanceLog.stream()
                .filter(r -> r.getCourseId() == course.getCourseId())
                .forEach(System.out::println);
    }

    // Save data to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
        System.out.println("\n✅ Attendance data saved to attendance_log.txt");
    }
}
