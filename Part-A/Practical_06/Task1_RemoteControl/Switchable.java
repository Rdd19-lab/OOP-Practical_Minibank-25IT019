interface Switchable {
    void on();
    void off();
    boolean isOn();
    default void toggle() { if (isOn()) off(); else on(); }
}
class Fan implements Switchable {
    private boolean state;
    public void on() { state = true; System.out.println("Fan ON"); }
    public void off() { state = false; System.out.println("Fan OFF"); }
    public boolean isOn() { return state; }
}
class Light implements Switchable {
    private boolean state;
    public void on() { state = true; System.out.println("Light ON"); }
    public void off() { state = false; System.out.println("Light OFF"); }
    public boolean isOn() { return state; }
}
@FunctionalInterface
interface SwitchRule { boolean maySwitchOn(Switchable device, int hour); }
