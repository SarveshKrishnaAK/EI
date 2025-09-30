package src.student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudentManager {
    private final Map<String, List<Student>> classroomStudents = new ConcurrentHashMap<>();

    public boolean enrollStudent(String studentId, String classroomName) {
        classroomStudents.putIfAbsent(classroomName, new ArrayList<>());
        List<Student> students = classroomStudents.get(classroomName);
        boolean exists = students.stream().anyMatch(s -> s.getId().equals(studentId));
        if (exists) return false;
        students.add(new Student(studentId, classroomName));
        return true;
    }

    public List<Student> listStudents(String classroomName) {
        return classroomStudents.getOrDefault(classroomName, Collections.emptyList());
    }
}
