package financial.firstdigital.online.model;

/**
 * The AccountStatus enumeration details the state of
 * account
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-15
 */

public enum AccountStatus {
    OPEN("Open"),
    CLOSED("Closed"),
    ON_HOLD("On Hold");

    private final String displayName;

    AccountStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
