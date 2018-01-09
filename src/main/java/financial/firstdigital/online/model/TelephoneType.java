package financial.firstdigital.online.model;

public enum TelephoneType {
    MOBILE("Mobile"),
    HOME("Home"),
    WORK("Work");

    private final String displayName;

    TelephoneType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}