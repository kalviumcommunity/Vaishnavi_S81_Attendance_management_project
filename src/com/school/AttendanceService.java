package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overloaded: mark by objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance for " + student.getName() + " in " + course.getCourseName() + ": " + record.getStatus());
    }

    // Overloaded: mark by IDs (uses RegistrationService for lookups)
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        if (student == null || course == null) {
            System.out.println("❌ Could not find Student or Course for IDs: " + studentId + ", " + courseId);
            return;
        }
        markAttendance(student, course, status);
    }

    // Display all records
    public void displayAttendanceLog() {
        System.out.println("\n=== Attendance Log (All Records) ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("(No attendance records)");
            return;
        }
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    // Display by student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance Log for Student: " + student.getName() + " ===");
        boolean found = false;
        for (AttendanceRecord r : attendanceLog) {
            if (r.getStudent() != null && r.getStudent().getId() == student.getId()) {
                r.displayRecord();
                found = true;
            }
        }
        if (!found) System.out.println("(No records for this student)");
    }

    // Display by course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance Log for Course: " + course.getCourseName() + " ===");
        boolean found = false;
        for (AttendanceRecord r : attendanceLog) {
            if (r.getCourse() != null && r.getCourse().getCourseId() == course.getCourseId()) {
                r.displayRecord();
                found = true;
            }
        }
        if (!found) System.out.println("(No records for this course)");
    }

    // Save attendance log to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
