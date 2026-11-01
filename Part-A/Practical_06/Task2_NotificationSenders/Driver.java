public class Driver {
    public static void main(String[] args) {
        UrgentNotifier email = message -> System.out.println("EMAIL: " + message);
        Notifier sms = message -> System.out.println("SMS: " + message);
        Notifier[] senders = {email, sms};
        String message = "Your account statement is ready.";
        for (Notifier sender : senders) {
            sender.send(message);
            if (sender instanceof Urgent) sender.send("URGENT: " + message);
        }
    }
}
