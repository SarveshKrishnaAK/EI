package src.student;

public class Student {
    private final String id;
    private final String classroomName;

    public Student(String id, String classroomName) {
        this.id = id;
        this.classroomName = classroomName;
    }

    public String getId() {
        return id;
    }

    public String getClassroomName() {
        return classroomName;
    }
}
