public class Driver {
    public static void main(String[] args) {
        PasswordChecker checker = new PasswordChecker();
        for (String password : new String[]{"abc", "Abcd1234!"}) {
            System.out.println(password + " : " + checker.strength(password));
            checker.printRules(password);
        }
    }
}
