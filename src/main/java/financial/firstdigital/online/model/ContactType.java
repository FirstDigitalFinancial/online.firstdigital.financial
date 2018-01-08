package financial.firstdigital.online.model;

public enum ContactType {
    PRIMARY("Primary"),
    SECONDARY("Secondary");

    private final String displayName;

    ContactType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
