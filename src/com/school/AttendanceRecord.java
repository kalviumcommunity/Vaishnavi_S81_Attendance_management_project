package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status; // "Present", "Absent", or "Invalid"

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if (status == null) status = "";
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid status entered for student ID " + (student != null ? student.getId() : "N/A"));
        }
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getStatus() { return status; }

    public void displayRecord() {
        if (student != null && course != null) {
            System.out.println("Student: " + student.getName() +
                               " (ID: " + student.getId() + ") | Course: " +
                               course.getCourseName() + " (ID: " + course.getCourseId() + ") | Status: " + status);
        } else {
            System.out.println("AttendanceRecord: incomplete data (student/course null) | Status: " + status);
        }
    }

    @Override
    public String toDataString() {
        // store by IDs for file: studentId,courseId,status
        int sid = (student != null) ? student.getId() : -1;
        int cid = (course != null) ? course.getCourseId() : -1;
        return sid + "," + cid + "," + status;
    }

    @Override
    public String toString() {
        String sname = (student != null) ? student.getName() : "N/A";
        String cname = (course != null) ? course.getCourseName() : "N/A";
        return "Student: " + sname + " (ID: " + (student != null ? student.getId() : "N/A") + ") | Course: " +
                cname + " (ID: " + (course != null ? course.getCourseId() : "N/A") + ") | Status: " + status;
    }
}
