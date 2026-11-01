import java.lang.reflect.Method;

public class Driver {
    public static void main(String[] args) throws Exception {
        Object tests = new MathTests();
        int passed = 0, failed = 0;
        for (Method method : tests.getClass().getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Run.class)) continue;
            try { method.invoke(tests); System.out.println(method.getName() + ": PASS"); passed++; }
            catch (Exception ex) { System.out.println(method.getName() + ": FAIL"); failed++; }
        }
        System.out.println("Passed: " + passed + ", Failed: " + failed);
    }
}
