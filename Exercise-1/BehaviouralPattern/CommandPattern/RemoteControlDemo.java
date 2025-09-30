// Main method for Command Pattern Demo
public class RemoteControlDemo {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Enter command (on/off/exit): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) break;
            if (input.equals("on")) {
                remote.setCommand(new LightOnCommand(light));
                remote.pressButton();
            } else if (input.equals("off")) {
                remote.setCommand(new LightOffCommand(light));
                remote.pressButton();
            } else {
                System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}
