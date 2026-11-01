import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    static List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (field.isAnnotationPresent(NotBlank.class) &&
                        (value == null || value.toString().isBlank())) errors.add(field.getName() + " must not be blank");
                MaxLength max = field.getAnnotation(MaxLength.class);
                if (max != null && value != null && value.toString().length() > max.value())
                    errors.add(field.getName() + " exceeds " + max.value() + " characters");
            } catch (IllegalAccessException ex) { errors.add("Cannot read " + field.getName()); }
        }
        return errors;
    }
    public static void main(String[] args) {
        System.out.println(validate(new SignupForm("", "AhmedabadCity")));
    }
}
