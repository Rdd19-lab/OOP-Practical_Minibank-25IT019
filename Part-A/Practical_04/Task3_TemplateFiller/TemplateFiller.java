import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {
    private static final Pattern PLACEHOLDER = Pattern.compile("\\{(\\w+)\\}");

    public String fill(String template, String[] names, String[] values) {
        if (names.length != values.length) throw new IllegalArgumentException("Names and values must have the same length.");
        StringBuilder result = new StringBuilder();
        Matcher matcher = PLACEHOLDER.matcher(template);
        int position = 0;
        while (matcher.find()) {
            result.append(template, position, matcher.start());
            String replacement = matcher.group();
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(matcher.group(1))) {
                    replacement = values[i];
                    break;
                }
            }
            result.append(replacement);
            position = matcher.end();
        }
        result.append(template.substring(position));
        return result.toString();
    }
}
