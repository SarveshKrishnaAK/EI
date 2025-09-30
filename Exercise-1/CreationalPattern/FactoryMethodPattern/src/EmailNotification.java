public class EmailNotification implements Notification {
    public void notifyUser(String message) {
        System.out.println("Email: " + message);
    }
}
