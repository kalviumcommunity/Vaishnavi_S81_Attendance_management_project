// package com.school;

// public class AttendanceRecord {
//     private int studentId;
//     private int courseId;
//     private String status;

//     public AttendanceRecord(int studentId, int courseId, String status) {
//         this.studentId = studentId;
//         this.courseId = courseId;

//         if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
//             this.status = status;
//         } else {
//             System.out.println("Warning: Invalid attendance status provided. Setting status to 'Invalid'.");
//             this.status = "Invalid";
//         }
//     }

//     public int getStudentId() {
//         return studentId;
//     }

//     public int getCourseId() {
//         return courseId;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void displayRecord() {
//         System.out.println("Attendance Record:");
//         System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Status: " + status);
//     }
// }

package com.school;

public class AttendanceRecord {
    private Student student;   // Changed from int studentId
    private Course course;     // Changed from int courseId
    private String status;

    // Updated constructor
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        this.status = status;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Updated display method
    public void displayRecord() {
        System.out.println(
            "Student: " + student.getName() + " (ID: " + student.getId() + ")" +
            " | Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")" +
            " | Status: " + status
        );
    }

    // Keep IDs for file saving
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
