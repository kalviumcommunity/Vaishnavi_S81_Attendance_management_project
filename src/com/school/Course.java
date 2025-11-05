// package com.school;

// public class Course {
//     private static int nextCourseIdCounter = 101;
//     private int courseId;
//     private String courseName;

//     public Course(String courseName) {
//         this.courseId = nextCourseIdCounter++;
//         this.courseName = courseName;
//     }

    
//     public int getCourseId() {
//         return courseId;
//     }

//     public String getCourseName() {
//         return courseName;
//     }

//     public void displayDetails() {
//         System.out.println("Course ID: " + courseId);
//         System.out.println("Course Name: " + courseName);
//     }
// }

package com.school;

public class Course {
    private int courseId;
    private String courseName;

    // Constructor
    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    // Display method (optional)
    public void displayCourse() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName);
    }
}
