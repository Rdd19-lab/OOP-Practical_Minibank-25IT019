import java.util.stream.LongStream;

public class ArraySumDriver {
    public static void main(String[] args) throws InterruptedException {
        long[] numbers = LongStream.rangeClosed(1, 1_000_000).toArray();
        ArraySum sum = new ArraySum(numbers);
        long expected = 500_000_500_000L;
        System.out.println("Expected sum: " + expected);
        System.out.println("Unsynchronized shared total: " + sum.sumUnsafely(8));
        System.out.println("Synchronized total: " + sum.sumWithSynchronization(8));
        System.out.println("LongAdder total: " + sum.sumWithLongAdder(8));
    }
}
