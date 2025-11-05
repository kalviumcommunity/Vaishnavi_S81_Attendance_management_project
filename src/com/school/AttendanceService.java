// // package com.school;

// // public class AttendanceRecord {
// //     private int studentId;
// //     private int courseId;
// //     private String status;

// //     public AttendanceRecord(int studentId, int courseId, String status) {
// //         this.studentId = studentId;
// //         this.courseId = courseId;

// //         if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
// //             this.status = status;
// //         } else {
// //             System.out.println("Warning: Invalid attendance status provided. Setting status to 'Invalid'.");
// //             this.status = "Invalid";
// //         }
// //     }

// //     public int getStudentId() {
// //         return studentId;
// //     }

// //     public int getCourseId() {
// //         return courseId;
// //     }

// //     public String getStatus() {
// //         return status;
// //     }

// //     public void displayRecord() {
// //         System.out.println("Attendance Record:");
// //         System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Status: " + status);
// //     }
// // }

// package com.school;

// public class AttendanceRecord {
//     private Student student;   // Changed from int studentId
//     private Course course;     // Changed from int courseId
//     private String status;

//     // Updated constructor
//     public AttendanceRecord(Student student, Course course, String status) {
//         this.student = student;
//         this.course = course;
//         this.status = status;
//     }

//     // Getters
//     public Student getStudent() {
//         return student;
//     }

//     public Course getCourse() {
//         return course;
//     }

//     public String getStatus() {
//         return status;
//     }

//     // Updated display method
//     public void displayRecord() {
//         System.out.println(
//             "Student: " + student.getName() + " (ID: " + student.getId() + ")" +
//             " | Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")" +
//             " | Status: " + status
//         );
//     }

//     // Keep IDs for file saving
//     public String toDataString() {
//         return student.getId() + "," + course.getCourseId() + "," + status;
//     }
// }


// package com.school;

// import java.util.*;

// public class AttendanceService {

//     private List<AttendanceRecord> attendanceLog;
//     private FileStorageService storageService;

//     // Constructor
//     public AttendanceService(FileStorageService storageService) {
//         this.attendanceLog = new ArrayList<>();
//         this.storageService = storageService;
//     }

//     // Overloaded markAttendance (Student + Course objects)
//     public void markAttendance(Student student, Course course, String status) {
//         AttendanceRecord record = new AttendanceRecord(student, course, status);
//         attendanceLog.add(record);
//     }

//     // Overloaded markAttendance (using IDs)
//     public void markAttendance(int studentId, int courseId, String status,
//                                List<Student> allStudents, List<Course> allCourses) {
//         Student student = findStudentById(studentId, allStudents);
//         Course course = findCourseById(courseId, allCourses);
//         if (student != null && course != null) {
//             markAttendance(student, course, status);
//         } else {
//             System.out.println("Error: Student or Course not found for IDs " + studentId + ", " + courseId);
//         }
//     }

//     private Student findStudentById(int id, List<Student> allStudents) {
//         for (Student s : allStudents) {
//             if (s.getId() == id) return s;
//         }
//         return null;
//     }

//     private Course findCourseById(int id, List<Course> allCourses) {
//         for (Course c : allCourses) {
//             if (c.getCourseId() == id) return c;
//         }
//         return null;
//     }

//     public void displayAttendanceLog() {
//         System.out.println("\n=== Full Attendance Log ===");
//         for (AttendanceRecord ar : attendanceLog) {
//             ar.displayRecord();
//         }
//     }

//     public void displayAttendanceLog(Student student) {
//         System.out.println("\n=== Attendance Log for Student: " + student.getName() + " ===");
//         for (AttendanceRecord ar : attendanceLog) {
//             if (ar.getStudent().equals(student)) {
//                 ar.displayRecord();
//             }
//         }
//     }

//     public void displayAttendanceLog(Course course) {
//         System.out.println("\n=== Attendance Log for Course: " + course.getCourseName() + " ===");
//         for (AttendanceRecord ar : attendanceLog) {
//             if (ar.getCourse().equals(course)) {
//                 ar.displayRecord();
//             }
//         }
//     }

//     public void saveAttendanceData() {
//         storageService.saveData(attendanceLog, "attendance_log.txt");
//         System.out.println("\nAttendance data saved to attendance_log.txt");
//     }
// }

package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid status entered for student ID " + studentId);
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    // Display method
    public void displayRecord() {
        System.out.println("Student ID: " + studentId + ", Course ID: " + courseId + ", Status: " + status);
    }
}
