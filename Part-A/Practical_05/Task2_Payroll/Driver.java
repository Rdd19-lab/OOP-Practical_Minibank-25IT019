public class Driver {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Aarav", "E101", 45000),
                new PartTimeEmployee("Diya", "E102", 80, 300),
                new Intern("Karan", "I103", 12000)
        };
        double total = 0;
        for (Employee e : employees) {
            double salary = e.monthlySalary();
            System.out.printf("%s (%s) monthly salary: Rs. %.2f", e.name, e.id, salary);
            if (e instanceof Intern) System.out.print(" — intern stipend");
            System.out.println();
            total += salary;
        }
        System.out.printf("Total payroll: Rs. %.2f%n", total);
    }
}
