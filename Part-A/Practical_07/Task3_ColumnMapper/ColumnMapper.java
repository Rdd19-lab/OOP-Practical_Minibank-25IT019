import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD)
@interface Column { String name(); }

class CustomerRow {
    @Column(name = "customer_name") private String name;
    @Column(name = "email_address") private String email;

    @Override public String toString() { return "CustomerRow{name='" + name + "', email='" + email + "'}"; }
}

public class ColumnMapper {
    public static <T> T map(Class<T> type, String[] headers, String[] row) throws ReflectiveOperationException {
        if (headers.length != row.length) throw new IllegalArgumentException("Header and data column counts must match.");
        T object = type.getDeclaredConstructor().newInstance();
        for (Field field : type.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) continue;
            int index = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(column.name())) { index = i; break; }
            }
            if (index < 0) throw new IllegalArgumentException("Missing required column: " + column.name());
            field.setAccessible(true);
            field.set(object, convert(row[index], field.getType()));
        }
        return object;
    }

    private static Object convert(String value, Class<?> type) {
        if (type == String.class) return value;
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == long.class || type == Long.class) return Long.parseLong(value);
        if (type == double.class || type == Double.class) return Double.parseDouble(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        throw new IllegalArgumentException("Unsupported column type: " + type.getName());
    }
}
