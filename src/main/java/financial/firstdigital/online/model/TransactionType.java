package financial.firstdigital.online.model;

/**
 * The TransactionType enumeration details the types of
 * transactions that can take place on a customer
 * account
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-16
 */

public enum TransactionType {
    DEPOST("Deposit"),
    WITHDRAW("Withdraw"),
    TRANSFER("Transfer"),
    CHARGE("Charge"),
    REFUND("Refund"),
    EXCHANGE("Exchange");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}