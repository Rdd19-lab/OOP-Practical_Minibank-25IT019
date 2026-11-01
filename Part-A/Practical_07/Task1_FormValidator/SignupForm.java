import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface NotBlank {}
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface MaxLength { int value(); }

public class SignupForm {
    @NotBlank private final String username;
    @MaxLength(12) private final String city;
    public SignupForm(String username, String city) { this.username = username; this.city = city; }
}
