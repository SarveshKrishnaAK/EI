// Main method for Singleton Pattern Demo
public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("First log message");
        logger2.log("Second log message");
        System.out.println("Logger objects are same: " + (logger1 == logger2));
    }
}
