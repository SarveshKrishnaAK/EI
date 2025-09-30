// Main method for Strategy Pattern Demo
public class PaymentStrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Enter payment method (creditcard/paypal/crypto) or 'exit': ");
            String method = scanner.nextLine().trim().toLowerCase();
            if (method.equals("exit")) break;
            System.out.println("Enter amount: ");
            int amount;
            try {
                amount = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
                continue;
            }
            switch (method) {
                case "creditcard":
                    context.setStrategy(new CreditCardPayment());
                    break;
                case "paypal":
                    context.setStrategy(new PayPalPayment());
                    break;
                case "crypto":
                    context.setStrategy(new CryptoPayment());
                    break;
                default:
                    System.out.println("Unknown payment method.");
                    continue;
            }
            context.pay(amount);
        }
        scanner.close();
    }
}
