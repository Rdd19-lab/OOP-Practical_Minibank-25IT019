public class Thermostat {
    private static final int MIN = 16, MAX = 30;
    private static int activeCount;
    private final String location;
    private int temperature;

    public Thermostat(String location, int start) {
        this.location = location;
        this.temperature = start >= MIN && start <= MAX ? start : 22;
        activeCount++;
    }

    public Thermostat(String location) { this(location, 22); }

    public void raise() {
        if (temperature < MAX) temperature++;
        else System.out.println("Already at maximum (" + MAX + ")");
    }

    public void lower() {
        if (temperature > MIN) temperature--;
        else System.out.println("Already at minimum (" + MIN + ")");
    }

    public int getTemperature() { return temperature; }
    public static int getActiveCount() { return activeCount; }

    public static void main(String[] args) {
        Thermostat living = new Thermostat("Living Room", 25);
        Thermostat bedroom = new Thermostat("Bedroom");
        for (int i = 0; i < 10; i++) { living.raise(); System.out.println(living.location + ": " + living.getTemperature()); }
        for (int i = 0; i < 20; i++) { living.lower(); System.out.println(living.location + ": " + living.getTemperature()); }
        System.out.println("Active thermostats: " + getActiveCount());
    }
}
