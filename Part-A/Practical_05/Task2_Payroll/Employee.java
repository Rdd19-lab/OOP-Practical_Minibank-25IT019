abstract class Employee {
    protected final String name;
    protected final String id;
    protected Employee(String name, String id) { this.name = name; this.id = id; }
    abstract double monthlySalary();
}
class FullTimeEmployee extends Employee {
    private final double salary;
    FullTimeEmployee(String name, String id, double salary) { super(name, id); this.salary = salary; }
    @Override double monthlySalary() { return salary; }
}
class PartTimeEmployee extends Employee {
    private final int hours;
    private final double rate;
    PartTimeEmployee(String name, String id, int hours, double rate) { super(name, id); this.hours = hours; this.rate = rate; }
    @Override double monthlySalary() { return hours * rate; }
}
class Intern extends Employee {
    private final double stipend;
    Intern(String name, String id, double stipend) { super(name, id); this.stipend = stipend; }
    @Override double monthlySalary() { return stipend; }
}
