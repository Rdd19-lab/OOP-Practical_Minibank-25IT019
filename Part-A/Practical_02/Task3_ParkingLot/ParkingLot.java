public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue;

    public ParkingLot(int twoCap, int fourCap) {
        if (twoCap < 0 || fourCap < 0) throw new IllegalArgumentException("Capacities cannot be negative.");
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public boolean park(String type) {
        if ("two".equalsIgnoreCase(type)) {
            if (twoWheelers >= twoCap) { System.out.println("Full: two-wheeler parking"); return false; }
            twoWheelers++;
            revenue += 20;
            return true;
        }
        if ("four".equalsIgnoreCase(type)) {
            if (fourWheelers >= fourCap) { System.out.println("Full: four-wheeler parking"); return false; }
            fourWheelers++;
            revenue += 40;
            return true;
        }
        throw new IllegalArgumentException("Type must be 'two' or 'four'.");
    }

    public void leave(String type) {
        if ("two".equalsIgnoreCase(type)) twoWheelers = Math.max(0, twoWheelers - 1);
        else if ("four".equalsIgnoreCase(type)) fourWheelers = Math.max(0, fourWheelers - 1);
        else throw new IllegalArgumentException("Type must be 'two' or 'four'.");
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 1);
        System.out.println("Two-wheeler parked: " + lot.park("two"));
        System.out.println("Two-wheeler parked: " + lot.park("two"));
        System.out.println("Two-wheeler parked: " + lot.park("two"));
        System.out.println("Four-wheeler parked: " + lot.park("four"));
        lot.leave("two");
        System.out.println("Occupancy - two-wheelers: " + lot.twoWheelers + ", four-wheelers: " + lot.fourWheelers);
        System.out.println("Revenue: Rs. " + revenue);
    }
}
