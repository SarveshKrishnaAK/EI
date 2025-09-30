package src.classroom;

import java.time.LocalTime;

public class ScheduledClass {
    private final String classroomName;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public ScheduledClass(String classroomName, LocalTime startTime, LocalTime endTime) {
        this.classroomName = classroomName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
