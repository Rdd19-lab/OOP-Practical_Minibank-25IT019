import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        int total = 0, bikes = 0, cars = 0, trucks = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter vehicle details. Type 'done' to finish.");
            while (true) {
                System.out.print("Vehicle number: ");
                String number = sc.next().trim();
                if (number.equalsIgnoreCase("done")) break;
                System.out.print("Vehicle type (bike/car/truck): ");
                String type = sc.next().trim().toLowerCase();
                Vehicle vehicle = new Vehicle(number, type);
                int toll = switch (vehicle.type()) {
                    case "bike" -> { bikes++; yield 20; }
                    case "car" -> { cars++; yield 50; }
                    case "truck" -> { trucks++; yield 150; }
                    default -> 0;
                };
                if (toll == 0) System.out.println("Unknown vehicle type.");
                else {
                    total += toll;
                    System.out.println(vehicle.number() + " toll: Rs. " + toll);
                }
            }
        }
        String frequent = bikes >= cars && bikes >= trucks ? "Bike" :
                cars >= trucks ? "Car" : "Truck";
        System.out.println("Total toll: " + total);
        System.out.println("Vehicle count - Bikes: " + bikes + ", Cars: " + cars + ", Trucks: " + trucks);
        System.out.println("Most frequent: " + frequent.toLowerCase());
    }
}
