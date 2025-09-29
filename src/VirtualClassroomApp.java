package src;

import java.util.List;

import src.classroom.ClassroomManager;
import src.classroom.ScheduledClassManager;
import src.classroom.ScheduledClass;
import src.student.AttendanceManager;
import src.student.AttendanceRecord;
import src.student.StudentManager;
import src.assignment.AssignmentManager;
import src.util.LoggerFactory;
// import src.util.RetryHandler;
import java.util.Scanner;
import java.util.logging.Logger;

public class VirtualClassroomApp {
    private final ClassroomManager classroomManager = new ClassroomManager();
    private final StudentManager studentManager = new StudentManager();
    private final AssignmentManager assignmentManager = new AssignmentManager();
    private final ScheduledClassManager scheduledClassManager = new ScheduledClassManager();
    private final AttendanceManager attendanceManager = new AttendanceManager();
    private final Logger logger = LoggerFactory.getLogger();

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Application started");
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                if (input == null || input.trim().equalsIgnoreCase("exit")) break;
                handleInput(input.trim());
            }
            logger.info("Application stopped");
        }
    }

    private void handleInput(String input) {
        try {
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String args = parts.length > 1 ? parts[1] : "";
            switch (command) {
                case "schedule_class": {
                    String[] scArgs = args.split(" ", 2);
                    if (scArgs.length < 2) { System.out.println("Usage: schedule_class <ClassName> <fromHH:mm-toHH:mm>"); break; }
                    String classroomName = scArgs[0];
                    String[] times = scArgs[1].split("-to");
                    if (times.length != 2) { System.out.println("Time format error. Use fromHH:mm-toHH:mm"); break; }
                    try {
                        java.time.LocalTime start = java.time.LocalTime.parse(times[0].replace("from", "").trim());
                        java.time.LocalTime end = java.time.LocalTime.parse(times[1].trim());
                        scheduledClassManager.scheduleClass(classroomName, start, end);
                        System.out.println("Class scheduled for " + classroomName + " from " + start + " to " + end);
                        logger.info("Class scheduled: " + classroomName + " from " + start + " to " + end);
                    } catch (Exception e) {
                        System.out.println("Invalid time format. Use HH:mm");
                    }
                    break;
                }
                case "join_class": {
                    String[] jcArgs = args.split(" ", 2);
                    if (jcArgs.length < 2) { System.out.println("Usage: join_class <StudentID> <ClassName>"); break; }
                    String studentId = jcArgs[0];
                    String classroomName = jcArgs[1];
                    java.time.LocalTime now = java.time.LocalTime.now();
                    java.util.List<src.classroom.ScheduledClass> schedules = scheduledClassManager.getSchedules(classroomName);
                    if (schedules.isEmpty()) {
                        System.out.println("No scheduled class found for " + classroomName);
                        break;
                    }
                    java.time.LocalTime endTime = schedules.get(schedules.size() - 1).getEndTime();
                    attendanceManager.studentJoin(classroomName, studentId, now, endTime);
                    System.out.println("Student " + studentId + " joined class " + classroomName + " at " + now + " (default leave: " + endTime + ")");
                    logger.info("Student joined: " + studentId + " in " + classroomName + " at " + now);
                    break;
                }
                case "leave_class": {
                    String[] lcArgs = args.split(" ", 2);
                    if (lcArgs.length < 2) { System.out.println("Usage: leave_class <StudentID> <ClassName>"); break; }
                    String studentId = lcArgs[0];
                    String classroomName = lcArgs[1];
                    java.time.LocalTime now = java.time.LocalTime.now();
                    attendanceManager.studentLeave(classroomName, studentId, now);
                    System.out.println("Student " + studentId + " left class " + classroomName + " at " + now);
                    logger.info("Student left: " + studentId + " in " + classroomName + " at " + now);
                    break;
                }
                case "list_attendance": {
                    String classroomName = args.trim();
                    if (classroomName.isEmpty()) { System.out.println("Usage: list_attendance <ClassName>"); break; }
                    java.util.Map<String, AttendanceRecord> att = attendanceManager.getClassAttendance(classroomName);
                    if (att.isEmpty()) {
                        System.out.println("No attendance records for " + classroomName);
                    } else {
                        att.forEach((sid, rec) -> System.out.println("Student: " + sid + ", Joined: " + rec.getJoinTime() + ", Left: " + (rec.getLeaveTime() != null ? rec.getLeaveTime() : "-") ));
                    }
                    break;
                }
                case "add_classroom":
                    if (classroomManager.addClassroom(args)) {
                        System.out.println("Classroom " + args + " has been created.");
                        logger.info("Classroom added: " + args);
                    } else {
                        System.out.println("Classroom already exists.");
                    }
                    break;
                case "add_student": {
                    String[] sArgs = args.split(" ", 2);
                    if (sArgs.length < 2) { System.out.println("Usage: add_student <ID> <ClassName|all>"); break; }
                    String studentId = sArgs[0];
                    String className = sArgs[1];
                    if (className.equalsIgnoreCase("all")) {
                        List<src.classroom.Classroom> allClassrooms = classroomManager.listClassrooms();
                        if (allClassrooms.isEmpty()) {
                            System.out.println("No classrooms available.");
                            break;
                        }
                        boolean anyEnrolled = false;
                        for (src.classroom.Classroom c : allClassrooms) {
                            if (studentManager.enrollStudent(studentId, c.getName())) {
                                System.out.println("Student " + studentId + " has been enrolled in " + c.getName() + ".");
                                logger.info("Student enrolled: " + studentId + " in " + c.getName());
                                anyEnrolled = true;
                            }
                        }
                        if (!anyEnrolled) {
                            System.out.println("Student already enrolled in all classrooms.");
                        }
                        break;
                    }
                    if (classroomManager.getClassroom(className) == null) {
                        System.out.println("Classroom does not exist.");
                        break;
                    }
                    if (studentManager.enrollStudent(studentId, className)) {
                        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
                        logger.info("Student enrolled: " + studentId + " in " + className);
                    } else {
                        System.out.println("Student already enrolled.");
                    }
                    break;
                }
                case "schedule_assignment": {
                    String[] aArgs = args.split(" ", 2);
                    if (aArgs.length < 2) { System.out.println("Usage: schedule_assignment <ClassName> <Details>"); break; }
                    if (assignmentManager.scheduleAssignment(aArgs[0], aArgs[1])) {
                        System.out.println("Assignment for " + aArgs[0] + " has been scheduled.");
                        logger.info("Assignment scheduled: " + aArgs[1] + " for " + aArgs[0]);
                    }
                    break;
                }
                case "submit_assignment": {
                    String[] subArgs = args.split(" ", 3);
                    if (subArgs.length < 3) { System.out.println("Usage: submit_assignment <StudentID> <ClassName> <Details>"); break; }
                    if (assignmentManager.submitAssignment(subArgs[0], subArgs[1], subArgs[2])) {
                        System.out.println("Assignment submitted by Student " + subArgs[0] + " in " + subArgs[1] + ".");
                        logger.info("Assignment submitted: " + subArgs[2] + " by " + subArgs[0] + " in " + subArgs[1]);
                    } else {
                        System.out.println("Assignment already submitted.");
                    }
                    break;
                }
                case "list_classrooms":
                    classroomManager.listClassrooms().forEach(c -> System.out.println(c.getName()));
                    break;
                case "list_students":
                    if (classroomManager.getClassroom(args) == null) {
                        System.out.println("Classroom does not exist.");
                        break;
                    }
                    studentManager.listStudents(args).forEach(s -> System.out.println(s.getId()));
                    break;
                case "list_assignments":
                    assignmentManager.listAssignments(args).forEach(a -> System.out.println(a.getDetails()));
                    break;
                case "remove_classroom":
                    if (classroomManager.removeClassroom(args)) {
                        System.out.println("Classroom removed: " + args);
                        logger.info("Classroom removed: " + args);
                    } else {
                        System.out.println("Classroom not found.");
                    }
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        } catch (Exception e) {
            logger.severe("Error handling input: " + e.getMessage());
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
