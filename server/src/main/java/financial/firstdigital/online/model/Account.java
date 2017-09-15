package financial.firstdigital.online.model;

/**
 * The Account class contains information
 * about the customer account
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-15
 */

public class Account {

    private String address;
    private Currency currency;
    private AccountStatus status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "address='" + address + '\'' +
                ", currency=" + currency +
                ", status=" + status +
                '}';
    }
}
