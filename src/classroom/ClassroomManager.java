package src.classroom;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClassroomManager {
    private final Map<String, Classroom> classrooms = new ConcurrentHashMap<>();

    public boolean addClassroom(String name) {
        if (classrooms.containsKey(name)) return false;
        classrooms.put(name, new Classroom(name));
        return true;
    }

    public boolean removeClassroom(String name) {
        return classrooms.remove(name) != null;
    }

    public List<Classroom> listClassrooms() {
        return new ArrayList<>(classrooms.values());
    }

    public Classroom getClassroom(String name) {
        return classrooms.get(name);
    }
}
