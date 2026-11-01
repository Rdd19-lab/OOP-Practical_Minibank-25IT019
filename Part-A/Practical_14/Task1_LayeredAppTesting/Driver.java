import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\n1. Add task  2. List tasks  3. Count  0. Exit");
                System.out.print("Choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Task title: ");
                        service.addTask(sc.nextLine());
                        System.out.println("Task added.");
                    }
                    case 2 -> service.getTasks().forEach(System.out::println);
                    case 3 -> System.out.println("Task count: " + service.getCount());
                    case 0 -> System.out.println("Application closed.");
                    default -> System.out.println("Invalid action.");
                }
            } while (choice != 0);
        }
    }
}
