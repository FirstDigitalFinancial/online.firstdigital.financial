package financial.firstdigital.online.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The TransactionDetail class contains information
 * about a transaction that has taken place on a
 * customers account
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-09-16
 */

@Entity
@Table(name = "fdf_transaction_detail")
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId", columnDefinition = "serial")
    private Long transactionId;

    @Column(name = "transactionType")
    private TransactionType transactionType;

    @Column(name = "tansactionValue")
    private BigDecimal transactionValue;

    @Column(name = "endOfTransactionBalance")
    private BigDecimal endOfTransactionBalance;

    @JoinColumn(name = "accountId")
    @ManyToOne
    private AccountDetail accountDetail;

    public TransactionDetail() {

    }

    public TransactionDetail(Long transactionId, TransactionType transactionType, BigDecimal transactionValue,
                             BigDecimal endOfTransactionBalance, AccountDetail accountDetail) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionValue = transactionValue;
        this.endOfTransactionBalance = endOfTransactionBalance;
        this.accountDetail = accountDetail;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public BigDecimal getEndOfTransactionBalance() {
        return endOfTransactionBalance;
    }

    public void setEndOfTransactionBalance(BigDecimal endOfTransactionBalance) {
        this.endOfTransactionBalance = endOfTransactionBalance;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "transactionId=" + transactionId +
                ", transactionType=" + transactionType +
                ", transactionValue=" + transactionValue +
                ", endOfTransactionBalance=" + endOfTransactionBalance +
                '}';
    }
}
