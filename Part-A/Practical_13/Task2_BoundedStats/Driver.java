public class Driver {
    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30, 40};
        Double[] decimals = {1.5, 2.5, 3.5};
        Long[] longs = {100L, 200L, 300L};
        System.out.printf("Integer average: %.2f%n", StatsCalculator.average(integers));
        System.out.printf("Double average: %.2f%n", StatsCalculator.average(decimals));
        System.out.printf("Long average: %.2f%n", StatsCalculator.average(longs));
    }
}
