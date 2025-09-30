package src.student;

import java.time.LocalTime;

public class AttendanceRecord {
    private final String studentId;
    private final LocalTime joinTime;
    private LocalTime leaveTime;

    public AttendanceRecord(String studentId, LocalTime joinTime, LocalTime leaveTime) {
        this.studentId = studentId;
        this.joinTime = joinTime;
        this.leaveTime = leaveTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public LocalTime getJoinTime() {
        return joinTime;
    }

    public LocalTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalTime leaveTime) {
        this.leaveTime = leaveTime;
    }
}
