// Main method for Factory Method Pattern Demo
public class NotificationFactoryDemo {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Enter notification type (email/sms/push) or 'exit': ");
            String type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("exit")) break;
            System.out.println("Enter message: ");
            String message = scanner.nextLine();
            try {
                Notification notification = NotificationFactory.createNotification(type);
                notification.notifyUser(message);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown notification type.");
            }
        }
        scanner.close();
    }
}
