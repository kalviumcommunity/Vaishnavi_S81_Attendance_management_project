package com.school;

import java.util.*;
import java.io.*;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService fileStorageService;

    public RegistrationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    // --- Registration methods ---
    public void registerStudent(Student student) {
        students.add(student);
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    // --- Getters ---
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // --- Lookup methods ---
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    // --- Combine all people ---
    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    // --- Save all data ---
    public void saveAllRegistrations() {
        fileStorageService.saveData("students.txt", students);
        fileStorageService.saveData("teachers.txt", teachers);
        fileStorageService.saveData("staff.txt", staffMembers);
        fileStorageService.saveData("courses.txt", courses);
    }
}
