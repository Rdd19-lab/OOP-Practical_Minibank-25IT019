public class Driver {
    public static void main(String[] args) {
        GenericStack<Integer> numbers = new GenericStack<>(5);
        numbers.push(10); numbers.push(20);
        System.out.println("Integer stack pop: " + numbers.pop());
        GenericStack<String> words = new GenericStack<>(5);
        words.push("Java"); words.push("OOP");
        System.out.println("String stack pop: " + words.pop());
        System.out.println("Integer stack empty: " + numbers.isEmpty());
    }
}
