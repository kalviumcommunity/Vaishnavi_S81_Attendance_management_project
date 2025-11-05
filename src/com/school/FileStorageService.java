// package com.school;

// import java.io.*;
// import java.util.List;

// public class FileStorageService {

//     public void saveData(List<? extends Storable> items, String filename) {
//         try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
//             for (Storable item : items) {
//                 writer.println(item.toDataString());
//             }
//             System.out.println("Data saved successfully to " + filename);
//         } catch (IOException e) {
//             System.out.println("Error writing to file: " + filename);
//             e.printStackTrace();
//         }
//     }
// }

// Create an instance of FileStorageService
FileStorageService storage = new FileStorageService();

// Save students, courses, and attendance records to text files
storage.saveStudents(students, "students.txt");
storage.saveCourses(courses, "courses.txt");
storage.saveAttendance(records, "attendance_log.txt");

System.out.println("\nData saved successfully to text files!");

