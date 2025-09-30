*This project is part of a placement drive and demonstrates real-world backend design for EdTech platforms.*
# EI
Placement Drive

---

# Virtual Classroom Manager (EI)

A robust, terminal-based Java application for managing virtual classrooms, student attendance, and assignment workflows. Designed for real-world EdTech scenarios, this project demonstrates best practices in software engineering, modularity, and defensive programming.

## 🚀 Key Features
- **Classroom Management:** Add, list, and remove virtual classrooms
- **Student Management:** Enroll students (individually or in all classrooms), list students per classroom
- **Session Scheduling:** Schedule classes with time slots (from HH:mm to HH:mm)
- **Attendance Tracking:**
  - Students join/leave classes; attendance is monitored with join/leave times
  - Default leave time is set to class end if not explicitly left
  - Attendance can be finalized manually
- **Assignment Management:** Schedule assignments for classrooms, submit assignments per student
- **Comprehensive Logging:** All actions are logged for traceability
- **Exception & Transient Error Handling:** Defensive programming throughout

## 🛠️ How to Run
1. **Prerequisite:** Java 17 or higher
2. **Compile:**
   ```sh
   javac -d out src/classroom/*.java src/student/*.java src/assignment/*.java src/util/*.java src/*.java
   ```
3. **Run:**
   ```sh
   java -cp out src.Main
   ```

## 📝 Example Workflow
```
add_classroom Math101
add_student S001 Math101
schedule_class Math101 from09:00-to10:00
join_class S001 Math101
leave_class S001 Math101
list_attendance Math101
schedule_assignment Math101 Assignment1:Read Chapter 1
submit_assignment S001 Math101 Assignment1:Read Chapter 1
```

## 🏗️ Project Structure
- `src/classroom/` — Classroom and session management
- `src/student/` — Student, attendance, and attendance record management
- `src/assignment/` — Assignment and submission management
- `src/util/` — Logging, retry, and exception utilities
- `src/Main.java` — Application entry point
- `src/VirtualClassroomApp.java` — Main application logic and command handling

## 💡 Design & Best Practices
- **SOLID Principles** and modular design
- **Manager pattern** for domain logic
- **Factory pattern** for logging
- **Defensive programming** and input validation
- **Extensible** for future features (e.g., persistence, reporting)

## 👤 Author & Contact
- [Sarvesh Krishna A K](mailto:sarveshkrishnaak@gmail.com)
- [GitHub: SarveshKrishnaAK](https://github.com/SarveshKrishnaAK)


