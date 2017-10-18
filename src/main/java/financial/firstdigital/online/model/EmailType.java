package financial.firstdigital.online.model;

/**
 * The EmailType enumeration details the types of email addresses
 * in the system
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-11
 */
public enum EmailType {
    PRIMARY("Primary"),
    SECONDARY("Secondary");

    private final String displayName;

    EmailType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
