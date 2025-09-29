package src.classroom;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ScheduledClassManager {
    private final Map<String, List<ScheduledClass>> classSchedules = new ConcurrentHashMap<>();

    public boolean scheduleClass(String classroomName, LocalTime start, LocalTime end) {
        classSchedules.putIfAbsent(classroomName, new ArrayList<>());
        classSchedules.get(classroomName).add(new ScheduledClass(classroomName, start, end));
        return true;
    }

    public List<ScheduledClass> getSchedules(String classroomName) {
        return classSchedules.getOrDefault(classroomName, Collections.emptyList());
    }
}
