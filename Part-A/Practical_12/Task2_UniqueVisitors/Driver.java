public class Driver {
    public static void main(String[] args) {
        VisitorTracker tracker = new VisitorTracker();
        for (String name : new String[]{"aarav", "diya", "aarav", "karan", "diya", "riya"})
            tracker.record(name);
        System.out.println("Unique visitors: " + tracker.uniqueCount());
        System.out.println("First three: " + tracker.firstThree());
    }
}
