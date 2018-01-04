package financial.firstdigital.online.validation;

import java.util.regex.Pattern;

public class EmailValidation implements Validation {
    private static String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,9}$";

    @Override
    public boolean validate(String email) {
        return Pattern.matches(REGEX, email);
    }
}
