package src.student;

import src.student.AttendanceRecord;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AttendanceManager {
    // Map<classroomName, Map<studentId, AttendanceRecord>>
    private final Map<String, Map<String, AttendanceRecord>> attendance = new ConcurrentHashMap<>();

    public void studentJoin(String classroomName, String studentId, LocalTime joinTime, LocalTime defaultLeaveTime) {
        attendance.putIfAbsent(classroomName, new ConcurrentHashMap<>());
        attendance.get(classroomName).put(studentId, new AttendanceRecord(studentId, joinTime, defaultLeaveTime));
    }

    public void studentLeave(String classroomName, String studentId, LocalTime leaveTime) {
        Map<String, AttendanceRecord> classAttendance = attendance.get(classroomName);
        if (classAttendance != null && classAttendance.containsKey(studentId)) {
            classAttendance.get(studentId).setLeaveTime(leaveTime);
        }
    }

    public AttendanceRecord getAttendance(String classroomName, String studentId) {
        Map<String, AttendanceRecord> classAttendance = attendance.get(classroomName);
        return classAttendance != null ? classAttendance.get(studentId) : null;
    }

    public Map<String, AttendanceRecord> getClassAttendance(String classroomName) {
        return attendance.getOrDefault(classroomName, Collections.emptyMap());
    }
}
