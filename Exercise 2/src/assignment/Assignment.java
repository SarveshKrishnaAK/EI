package src.assignment;

public class Assignment {
    private final String details;
    private final String classroomName;

    public Assignment(String classroomName, String details) {
        this.classroomName = classroomName;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getClassroomName() {
        return classroomName;
    }
}
