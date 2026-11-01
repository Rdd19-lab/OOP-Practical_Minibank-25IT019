import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD) @interface Run {}

public class MathTests {
    @Run public void testAddition() { if (2 + 3 != 5) throw new AssertionError("addition"); }
    @Run public void testSubtraction() { if (8 - 3 != 5) throw new AssertionError("subtraction"); }
    public void helper() {}
}
