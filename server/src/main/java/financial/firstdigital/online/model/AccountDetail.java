package financial.firstdigital.online.model;

import javax.persistence.*;

/**
 * The AccountDetail class contains information
 * about the customer account
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-15
 */

@Entity
@Table(name = "fdf_accountdetail")
public class AccountDetail {

    @Id
    @Column(name = "accountNumber")
    private Long accountNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

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
        return "AccountDetail{" +
                "accountNumber=" + accountNumber +
                ", address='" + address + '\'' +
                ", currency=" + currency +
                ", status=" + status +
                '}';
    }
}
