package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService fileStorageService;

    public RegistrationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    // Registration methods
    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Registered student: " + student.getName() + " (ID: " + student.getId() + ")");
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Registered teacher: " + teacher.getName() + " (ID: " + teacher.getId() + ")");
    }

    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
        System.out.println("Registered staff: " + staff.getName() + " (ID: " + staff.getId() + ")");
    }

    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Created course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ", Capacity: " + course.getCapacity() + ")");
    }

    // Getters
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // Lookups
    public Student findStudentById(int id) {
        for (Student s : students) if (s.getId() == id) return s;
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) if (c.getCourseId() == id) return c;
        return null;
    }

    // Combined list of people for polymorphic display
    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    // Save all registrations to files
    public void saveAllRegistrations() {
        fileStorageService.saveData(students, "students.txt");
        fileStorageService.saveData(teachers, "teachers.txt");
        fileStorageService.saveData(staffMembers, "staff.txt");
        fileStorageService.saveData(courses, "courses.txt");
    }

    // Enroll student in course (uses Course.addStudent)
    public boolean enrollStudentInCourse(Student student, Course course) {
        if (student == null || course == null) {
            System.out.println("Enrollment failed: student or course is null.");
            return false;
        }
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println("Student " + student.getName() + " successfully enrolled in " + course.getCourseName());
        } else {
            System.out.println("Cannot enroll " + student.getName() + " — Course capacity full!");
        }
        return success;
    }
}
