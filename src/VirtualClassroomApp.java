package src;

import src.classroom.ClassroomManager;
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
                    if (sArgs.length < 2) { System.out.println("Usage: add_student <ID> <ClassName>"); break; }
                    if (studentManager.enrollStudent(sArgs[0], sArgs[1])) {
                        System.out.println("Student " + sArgs[0] + " has been enrolled in " + sArgs[1] + ".");
                        logger.info("Student enrolled: " + sArgs[0] + " in " + sArgs[1]);
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
