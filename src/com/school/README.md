# 🏫 School Management System  
---

## 📘 Overview
This project is a **console-based School Management System** built step-by-step through **10 code-along sessions**.  
It demonstrates strong **Object-Oriented Programming (OOP)** and **SOLID** principles using Java — managing students, teachers, staff, courses, and attendance data, with persistent storage.

By the end of Part 10, the system supports:
- Registration and management of students, teachers, staff, and courses.
- Attendance tracking with overloaded commands.
- Data persistence to text files.
- Course capacity management and automatic section balancing.

---

## 🧩 Project Structure
└── com/school/
├── Main.java
├── Person.java
├── Student.java
├── Teacher.java
├── Staff.java
├── Course.java
├── AttendanceRecord.java
├── Storable.java
├── FileStorageService.java
├── AttendanceService.java
└── RegistrationService.java


## 🧱 Part 1: Project Setup & Base Classes
**Goal:** Establish the base structure and `Person` class.  
- Created `Person.java` with fields: `id`, `name`, and `email`.
- Added constructor, getters, setters, and `displayDetails()` method.
- Created `Main.java` to print a welcome message.

---

## 🧩 Part 2: Composition and Course Relationship
**Goal:** Introduce `Course` class and link it with `Student`.  
- Added `Course.java` with fields `courseId`, `courseName`, and `teacher`.
- Established **composition** between `Student` and `Course`.
- Each `Student` can enroll in multiple `Courses`.
- Displayed course details for each student in `Main.java`.

---

## 🧩 Part 3: Inheritance & Polymorphism
**Goal:** Create hierarchy for school members.  
- Added subclasses of `Person`:  
  - `Student`
  - `Teacher`
  - `Staff`
- Overrode `displayDetails()` in each subclass.
- Demonstrated **polymorphism** by storing different person types in a `List<Person>` and displaying details dynamically.

---

## 🧩 Part 4: Attendance Tracking
**Goal:** Introduce attendance recording and validation.  
- Created `AttendanceRecord.java` with fields:
  - `student`, `course`, `status`, and `date`.
- Implemented attendance list in `Main.java`.
- Displayed attendance reports for each student.
- Introduced **data encapsulation** and validation for correct attendance marking.

---
## 🧩 Part 5: Establishing Hierarchy — Students, Teaching & Non-Teaching Staff
**Goal:** Implement an inheritance hierarchy with a base class `Person` and derived classes for `Student`, `Teacher`, and `Staff`.

### ✅ Features:
- Created a base class `Person` with:
  ```java
  protected int id;
  protected String name;
  protected String email;

Created subclasses:
-Student → inherits from Person
-Teacher → inherits from Person
-Staff → inherits from Person
-Overrode displayDetails() in each subclass.
-Demonstrated polymorphism by displaying multiple object types dynamically.
-Practiced data encapsulation and inheritance concepts.


---

## 🧩 Part 6: Interface-Driven Persistence (Storable Interface)

**Goal:** Enable each class to define its own data storage format using an interface.

### ✅ Features:

    Created an interface Storable:

    public interface Storable {
        String toDataString();
    }


Implemented Storable in:
    -Student
    -Teacher
    -Staff
    -Course
    
-Each class overrides toDataString() for consistent saving.
-Followed abstraction and interface-driven design.
-Prepared for file persistence in later parts.


---

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports

### 📘 Overview
In this part, the project demonstrates **runtime polymorphism** by using the `Person` hierarchy (`Student`, `Teacher`, `Staff`) and refines the `AttendanceRecord` class to work directly with objects instead of IDs.  
This allows the system to display detailed attendance information and use polymorphism to handle different types of people in the school seamlessly.


### 🧠 Concepts Demonstrated
- **Runtime Polymorphism (Dynamic Method Dispatch):**
  The `displayDetails()` method behaves differently based on the actual object type (`Student`, `Teacher`, or `Staff`).
- **Object Composition:**
  `AttendanceRecord` now holds object references, showing a strong “has-a” relationship.
- **Interface-driven persistence** from previous parts continues to work with updated structure.


---

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Implemented AttendanceService with overloaded `markAttendance` and `displayAttendanceLog` methods.
- Demonstrated flexible attendance marking using both objects and IDs.
- Integrated `FileStorageService` for saving records.
- Verified functionality through console output and saved `attendance_log.txt`.

### How to Run
1. Compile: `javac src/com/school/*.java`
2. Run: `java -cp src com.school.Main`
3. Check the generated `attendance_log.txt` file.

---

## Part 9: SOLID Service Layer — RegistrationService & AttendanceService Separation

### 🎯 Goal
Apply the **Single Responsibility Principle (SRP)** from the SOLID design principles by separating the system into dedicated service layers.  
This improves code organization, reusability, and maintainability.


 🧩 Key Updates

- **Created `RegistrationService.java`**
  - Handles registration and management of `Student`, `Teacher`, `Staff`, and `Course` entities.
  - Performs ID-based lookups and returns unified person lists.
  - Saves all entity data using `FileStorageService`.
  - Provides methods such as:
    - `registerStudent()`
    - `registerTeacher()`
    - `registerStaff()`
    - `createCourse()`
    - `findStudentById()`
    - `findCourseById()`
    - `saveAllRegistrations()`
    - `getAllPeople()`

- **Updated `Teacher.java` and `Staff.java`**
  - Both now implement the `Storable` interface.
  - Added `toDataString()` for file persistence.

- **Refactored `AttendanceService.java`**
  - Now depends on `RegistrationService` to look up students and courses by ID.
  - Removed redundant helper lookup methods.
  - Focused solely on attendance-related logic (`markAttendance`, `saveAttendanceData`).

- **Refactored `Main.java`**
  - Acts as the central orchestrator.
  - Creates and wires `FileStorageService`, `RegistrationService`, and `AttendanceService`.
  - Uses service methods to register users, create courses, and mark attendance.
  - Displays all registered entities using `registrationService.getAllPeople()`.


 🧠 SOLID Principle Applied:
**Single Responsibility Principle (SRP):**
Each service class (`RegistrationService`, `AttendanceService`, etc.) now has a single, well-defined responsibility.  
This ensures changes in one module (like student registration) don’t affect other modules (like attendance tracking).

---


