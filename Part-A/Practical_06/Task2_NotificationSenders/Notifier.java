@FunctionalInterface
interface Notifier {
    void send(String message);
}
interface Urgent {}
@FunctionalInterface
interface UrgentNotifier extends Notifier, Urgent {}
