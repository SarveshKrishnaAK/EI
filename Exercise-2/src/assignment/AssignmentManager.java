package src.assignment;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AssignmentManager {
    private final Map<String, List<Assignment>> classroomAssignments = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> submissions = new ConcurrentHashMap<>();

    public boolean scheduleAssignment(String classroomName, String details) {
        classroomAssignments.putIfAbsent(classroomName, new ArrayList<>());
        classroomAssignments.get(classroomName).add(new Assignment(classroomName, details));
        return true;
    }

    public boolean submitAssignment(String studentId, String classroomName, String details) {
        String key = classroomName + ":" + details;
        submissions.putIfAbsent(key, new HashSet<>());
        return submissions.get(key).add(studentId);
    }

    public List<Assignment> listAssignments(String classroomName) {
        return classroomAssignments.getOrDefault(classroomName, Collections.emptyList());
    }
}
