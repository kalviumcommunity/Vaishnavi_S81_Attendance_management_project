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