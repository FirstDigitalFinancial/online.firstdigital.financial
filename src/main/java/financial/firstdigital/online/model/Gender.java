package financial.firstdigital.online.model;

/**
 * The Gender enum contains details
 * about a customers gender
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */
public enum Gender {
    UNKNOWN("U"),
    MALE("M"),
    FEMALE("F"),
    NOT_APPLICABLE("N"),
    WITHHELD("W");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
