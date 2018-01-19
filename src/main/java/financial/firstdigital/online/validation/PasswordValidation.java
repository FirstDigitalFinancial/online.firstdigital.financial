package financial.firstdigital.online.validation;

import java.util.regex.Pattern;

public class PasswordValidation implements Validation {
    private static String REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

    @Override
    public boolean validate(String password) {
        return Pattern.matches(REGEX, password);
    }
}
