package util;

/**
 * Simple validation utilities.
 */
public final class Validator {

    private Validator() {
    }

    public static boolean isValidUsername(String username) {
        return username != null && username.trim().length() >= 3;
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
