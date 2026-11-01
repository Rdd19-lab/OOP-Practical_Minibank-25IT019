public class PasswordChecker {
    public String strength(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[^A-Za-z0-9].*")) score++;
        return score <= 1 ? "Weak" : score <= 3 ? "Medium" : "Strong";
    }
    public void printRules(String password) {
        System.out.println("Length >= 8: " + (password.length() >= 8));
        System.out.println("Uppercase: " + password.matches(".*[A-Z].*"));
        System.out.println("Digit: " + password.matches(".*[0-9].*"));
        System.out.println("Special: " + password.matches(".*[^A-Za-z0-9].*"));
    }
}
