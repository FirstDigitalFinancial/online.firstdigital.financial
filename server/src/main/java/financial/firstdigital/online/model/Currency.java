package financial.firstdigital.online.model;

/**
 * The Currency enumeration details the types of
 * currency
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-15
 */

public enum Currency {
    BITCOIN_CORE("Bitcoin Core"),
    BITCOIN_CASH("Bitcoin Cash"),
    ETHEREUM("Ethereum"),
    LITECOIN("Litecoin");

    private final String displayName;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}