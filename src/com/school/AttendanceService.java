
package com.school;

import java.util.*;

public class AttendanceService {
    private List<Attendance> attendanceRecords = new ArrayList<>();
    private FileStorageService fileStorageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService fileStorageService, RegistrationService registrationService) {
        this.fileStorageService = fileStorageService;
        this.registrationService = registrationService;
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student or course ID!");
            return;
        }

        Attendance record = new Attendance(student, course, status);
        attendanceRecords.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName());
    }

    public void saveAttendanceData() {
        fileStorageService.saveData("attendance_log.txt", attendanceRecords);
    }
}
