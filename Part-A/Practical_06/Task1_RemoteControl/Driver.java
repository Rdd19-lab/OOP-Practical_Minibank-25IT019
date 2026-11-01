public class Driver {
    public static void main(String[] args) {
        Switchable fan = new Fan();
        Switchable light = new Light();
        Switchable[] devices = {fan, light};
        for (Switchable device : devices) device.toggle();

        SwitchRule daytimeRule = new SwitchRule() {
            @Override public boolean maySwitchOn(Switchable device, int hour) {
                return !device.isOn() && hour >= 6 && hour <= 22;
            }
        };
        SwitchRule quietHoursRule = (device, hour) -> !device.isOn() && hour >= 8 && hour < 20;
        System.out.println("Anonymous rule allows fan at 10: " + daytimeRule.maySwitchOn(fan, 10));
        System.out.println("Lambda rule allows light at 21: " + quietHoursRule.maySwitchOn(light, 21));
    }
}
